package csitmnr.event;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Manoj Budha Ayer on 9/20/2017.
 */

public class MyAdapterClass extends RecyclerView.Adapter<MyAdapterClass.EventViewHolder> {
    Context context;
    List<Datum> list;

    public MyAdapterClass(Context context, List<Datum> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dataview,parent,false);
        return new EventViewHolder(view);


    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Datum data = list.get(position);
        final String title = data.getTitle();
        final String intro = data.getIntroText();
        final String detail = data.getDetail();
        final String eventDate = data.getEventDate();
        final String eventTime = data.getEventTime();
        final String eventVenue = data.getEventVenue();
        final String createdAt = data.getCreatedAt();
        final String updatedAt = data.getUpdatedAt();
        final String eventOrganizedBy = data.getEventOrganizedBy();
        final String image = data.getFeaturedImage();




        Glide
                .with(holder.itemView.getContext())
                .load(image)
                .into(holder.imageView);

        holder.title.setText(title);
        holder.intro.setText(intro);
        holder.detail.setText(detail);
        holder.eventDate.setText(eventDate);
        holder.eventTime.setText(eventTime);
        holder.eventVenue.setText(eventVenue);
        holder.createdAt.setText(createdAt);
        holder.updatedAt.setText(updatedAt);
        holder.eventOrganizedBy.setText(eventOrganizedBy);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,SecondActivity.class);

                intent.putExtra("image",image);
                intent.putExtra("title",title);
                intent.putExtra("intro",intro);
                intent.putExtra("detail",detail);
                intent.putExtra("eventDate",eventDate);
                intent.putExtra("eventTime",eventTime);
                intent.putExtra("eventVenue",eventVenue);
                intent.putExtra("createdAt",createdAt);
                intent.putExtra("updatedAT",updatedAt);
                intent.putExtra("eventOrganized",eventOrganizedBy);

                context.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title,intro,eventDate,eventTime,eventVenue,eventOrganizedBy,createdAt,updatedAt,detail;
        public EventViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            intro = itemView.findViewById(R.id.intro);
            eventDate = itemView.findViewById(R.id.eventDate);
            eventTime = itemView.findViewById(R.id.eventTime);
            eventVenue = itemView.findViewById(R.id.eventVenue);
            eventOrganizedBy = itemView.findViewById(R.id.eventOrganizedBy);
            createdAt = itemView.findViewById(R.id.createdAt);
            updatedAt = itemView.findViewById(R.id.updatedAt);
            detail = itemView.findViewById(R.id.detail);

        }
    }
}
