package tech.arvindrachuri.kloh;

import java.io.Serializable;

/**
 * Created by ARVIND on 5/22/2018.
 */

@SuppressWarnings("serial")
public class ActivityPreview implements Serializable {

    public String activityImageUrl;
    public String hostImageUrl;
    public String title;
    public String summary;
    public String location;
    public String time;
    public String hostName;
    public String description;
    public double latitude;
    public double longitude;

}
