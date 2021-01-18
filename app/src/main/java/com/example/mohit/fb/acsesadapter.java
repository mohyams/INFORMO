package com.example.mohit.fb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mohit on 06-04-2018.
 */

public class acsesadapter extends RecyclerView.Adapter<acsesadapter.ImageViewHolder> {

    private Context mContext;
    private List<Upload> mUploads;


    public acsesadapter(Context context,List<Upload> ACSES){
        mContext = context;
        mUploads = ACSES;

    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.acsesdisp,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
            Upload uploadCurrent = mUploads.get(position);
            holder.textViewName.setText(uploadCurrent.getEventName());
            holder.textViewContent.setText(uploadCurrent.getContent());
            holder.textViewTime.setText(uploadCurrent.getTime());
            holder.textViewDate.setText(uploadCurrent.getDate());
            holder.textViewVenue.setText(uploadCurrent.getVenue());
        Picasso.with(mContext)
                .load(uploadCurrent.getImageUrl())
                .fit()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;
        public TextView textViewContent;
        public TextView textViewTime;
        public TextView textViewDate;
        public TextView textViewVenue;

        public ImageView imageView;


        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewContent = itemView.findViewById(R.id.text_view_content);
            textViewTime = itemView.findViewById(R.id.text_view_time);
            textViewDate = itemView.findViewById(R.id.text_view_date);
            textViewVenue = itemView.findViewById(R.id.text_view_venue);

            imageView = itemView.findViewById(R.id.image_view_upload);
        }
    }
}
