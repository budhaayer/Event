package csitmnr.event;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        ImageView image = (ImageView) findViewById(R.id.imageView);

        TextView title = (TextView) findViewById(R.id.title);
        TextView intro = (TextView) findViewById(R.id.intro);
        TextView detail = (TextView) findViewById(R.id.detail);
        TextView createdAt = (TextView) findViewById(R.id.createdAt);
        TextView updatedAt = (TextView) findViewById(R.id.updatedAt);
        TextView eventVenue = (TextView) findViewById(R.id.eventVenue);
        TextView eventTime = (TextView) findViewById(R.id.eventTime);
        TextView eventDate = (TextView) findViewById(R.id.eventDate);
        TextView eventOrganizeBy = (TextView) findViewById(R.id.eventOrganizedBy);


        title.setText(getIntent().getExtras().getString("title"));
        intro.setText(getIntent().getExtras().getString("intro"));
        createdAt.setText(getIntent().getExtras().getString("createdAt"));
        updatedAt.setText(getIntent().getExtras().getString("updatedAT"));
        eventVenue.setText(getIntent().getExtras().getString("eventVenue"));
        eventTime.setText(getIntent().getExtras().getString("eventTime"));
        eventDate.setText(getIntent().getExtras().getString("eventDate"));
        eventOrganizeBy.setText(getIntent().getExtras().getString("eventOrganized"));
        detail.setText(getIntent().getExtras().getString("detail"));

        String imageString =getIntent().getExtras().getString("image");
        Glide
                .with(this)
                .load(imageString)
                .into(image);

//        image.setImageResource();

    }
}
