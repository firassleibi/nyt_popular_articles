package com.sharjahegov.nytpopulararticles;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.articlesList);

        //Load Articles
        loadArticles();





    }
    public void loadArticles(){
        final ArrayList<ArticleData> arrayList = new ArrayList<ArticleData>();
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        //API URL
        String url = getResources().getString(R.string.api_url) + "all-sections/1.json?api-key=" + getResources().getString(R.string.api_key);

        //Show loading Dialog
        final ProgressDialog dialog = ProgressDialog.show(this, "","Loading. Please wait...", true);



        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Hide Loading Dialog
                        dialog.hide();
                        try{
                            // JSON Parse
                            JSONObject data = new JSONObject(response);
                            JSONArray results = new JSONArray(data.getString("results"));
                            for(int i = 0;i< results.length();i++){
                                JSONObject article = results.getJSONObject(i);
                                String image = article.getJSONArray("media").getJSONObject(0).getJSONArray("media-metadata").getJSONObject(0).getString("url");
                                arrayList.add(new ArticleData(article.getInt("id"),article.getString("title"),article.getString("abstract"),image,article.getString("published_date")));
                            }

                            // Load Object List Into Adapter
                            ArticlesListAdapter customAdapter = new ArticlesListAdapter(MainActivity.this, arrayList);
                            list.setAdapter(customAdapter);
                        }
                        catch (Exception e){
                            Toast.makeText(MainActivity.this,"Loading error please try again",Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.hide();
                Toast.makeText(MainActivity.this,"Loading error please try again",Toast.LENGTH_LONG).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
