package com.sharjahegov.nytpopulararticles;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApiTester {
    @Test
    public void apiKeyCorrect(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        String api_key = appContext.getResources().getString(R.string.api_key);
        String api_url = appContext.getResources().getString(R.string.api_url);
        //API URL
        String uri = api_url + "all-sections/1.json?api-key=" + api_key;
        try{
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection)
                    url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            if(code == 401)
                fail();
        }
        catch (Exception e){
            fail();
        }


    }
}
