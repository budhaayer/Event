package csitmnr.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Datum> list = new ArrayList<>();

    private static final String url = "http://alfabeta.bidheegroup.com/api/v1/event";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray array = object.getJSONArray("data");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object1 = array.getJSONObject(i);

                        int id = object1.getInt("id");
                        String title = object1.getString("title");
                        String intro_text = object1.getString("intro_text");
                        String detail = object1.getString("detail");
                        String image = object1.getString("featured_image");
                        String eventDate = object1.getString("event_date");
                        String eventTime = object1.getString("event_time");
                        String eventVenue = object1.getString("event_venue");
                        String eventOrganizeBy = object1.getString("event_organized_by");
                        int createdById = object1.getInt("created_by_id");
                        String createdAt = object1.getString("created_at");
                        String updatedAt = object1.getString("updated_at");

                        Datum data = new Datum(id,title,intro_text,detail,image,eventDate,eventTime,eventVenue,eventOrganizeBy,createdById,createdAt,updatedAt);
                        list.add(data);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                MyAdapterClass adapterClass = new MyAdapterClass(MainActivity.this,list);
                recyclerView.setAdapter(adapterClass);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
