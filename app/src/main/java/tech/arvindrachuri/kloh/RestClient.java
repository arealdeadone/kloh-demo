package tech.arvindrachuri.kloh;

import android.util.Log;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by ARVIND on 5/22/2018.
 */

public class RestClient {
    final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    /**
     * Trust every server - dont check for any certificate
     */
    private static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }

            public void checkClientTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }
        } };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection
                    .setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void getActivityList() throws Exception{
        JSONObject payload = new JSONObject();
        payload.put("location", new JSONObject().put("lat", 12.926031).put("lon", 77.676246));
        final String sPayload = payload.toString();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    trustAllHosts();
                    URL url = new URL("https://api.kloh.in/kloh/external/v1/activity/list");
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setHostnameVerifier(DO_NOT_VERIFY);
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    conn.connect();

                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    os.writeBytes(sPayload);
                    os.flush();
                    os.close();

                    Log.d("Kloh", conn.getResponseMessage());
                } catch (Exception e){
                    Log.e("Kloh", e.getLocalizedMessage());
                }
            }
        });

        thread.start();
    }
}
