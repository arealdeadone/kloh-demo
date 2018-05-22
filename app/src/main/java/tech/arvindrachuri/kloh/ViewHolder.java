package tech.arvindrachuri.kloh;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ARVIND on 5/22/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder {


    public ImageView activityImage;
    public ImageView hostImage;
    public TextView activityName;
    public TextView activitySummary;
    public TextView locationTime;
    public AppCompatButton readMore;

    public ViewHolder(View itemView) {
        super(itemView);
        activityImage = itemView.findViewById(R.id.activity_image);
        hostImage = itemView.findViewById(R.id.host_image);
        activityName = itemView.findViewById(R.id.event_name);
        activitySummary = itemView.findViewById(R.id.event_summary);
        locationTime = itemView.findViewById(R.id.location_time_id);
        readMore = itemView.findViewById(R.id.readmore_btn);
    }
}
