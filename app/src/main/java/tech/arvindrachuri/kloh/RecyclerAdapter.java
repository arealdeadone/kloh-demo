package tech.arvindrachuri.kloh;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ARVIND on 5/22/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<ActivityPreview> activityPreviews;
    Context context;

    public RecyclerAdapter(List<ActivityPreview> activityPreviews, Context context) {
        this.activityPreviews = activityPreviews;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ActivityPreview activityPreview = activityPreviews.get(position);
        holder.activityName.setText(activityPreview.title);
        holder.activitySummary.setText(activityPreview.summary);
        holder.locationTime.setText(activityPreview.location+", "+activityPreview.time);
        Picasso.get().load(activityPreview.activityImageUrl).placeholder(R.drawable.placeholder).into(holder.activityImage);
        Picasso.get().load(activityPreview.hostImageUrl).placeholder(R.drawable.img1).into(holder.hostImage);
        holder.readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailsActivity.class);
                i.putExtra("details", activityPreview);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return activityPreviews.size();
    }
}
