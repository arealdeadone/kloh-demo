package tech.arvindrachuri.kloh;


import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by ARVIND on 5/22/2018.
 */

public class APIcalls {

    private static final String BASE_URL = "https://api.kloh.in/kloh/external/v1/activity/";
    private static AsyncHttpClient client = new AsyncHttpClient(true, 80, 443);

    public static void get(String url, AsyncHttpResponseHandler responseHandler){
        client.get(getAbsoluteUrl(url), responseHandler);
    }

    public static void post(Context context, String url, JSONObject payload, AsyncHttpResponseHandler responseHandler)throws Exception{
        StringEntity entity = new StringEntity(payload.toString());
        entity.setContentType("application/json");
        Log.d("Kloh", "Here...");
        client.post(context, getAbsoluteUrl(url), entity, "application/json", responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl){
        return BASE_URL+relativeUrl;
    }
}
