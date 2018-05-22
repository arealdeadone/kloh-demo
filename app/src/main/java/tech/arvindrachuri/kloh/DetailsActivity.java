package tech.arvindrachuri.kloh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity{

    ImageView eventImage;
    ImageView hostImage;

    TextView eventName;
    TextView eventSummary;
    TextView eventDescription;
    TextView locationTime;
    TextView hostName;

    double lat=12.926031,lon=77.676246;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i = getIntent();
        ActivityPreview details = (ActivityPreview)i.getSerializableExtra("details");

        eventImage = findViewById(R.id.activity_image_details);
        Picasso.get().load(details.activityImageUrl).placeholder(R.drawable.placeholder).into(eventImage);

        hostImage = findViewById(R.id.host_image_details);
        Picasso.get().load(details.hostImageUrl).placeholder(R.drawable.img1).into(hostImage);

        eventName = findViewById(R.id.event_name_details);
        eventName.setText(details.title);

        eventSummary = findViewById(R.id.event_summary_details);
        eventSummary.setText(details.summary);

        eventDescription = findViewById(R.id.event_desc_details);
        eventDescription.setText(details.description);

        locationTime = findViewById(R.id.location_time_details);
        locationTime.setText(details.location+", "+details.time);

        hostName = findViewById(R.id.host_name_details);
        hostName.setText(details.hostName);

        lat = details.latitude;
        lon = details.longitude;
    }
}
