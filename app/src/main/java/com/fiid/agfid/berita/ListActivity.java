package com.fiid.agfid.berita;

import android.support.v7.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements Adapter.OnItemClickListener {
    private RecyclerView mRecyclerView, recyclerView;
    private Adapter mAdapter;
    private ArrayList<Item> mNewsItems;
    private RequestQueue mRequestQueue;
    public static final String NEWS_URL = "news";
    public static final String EXTRA_IMAGE="image";
    public static final String EXTRA_TITTLE="title";
    public static final String EXTRA_KONTEN="content";
    public ListActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mRecyclerView = findViewById(R.id.siji);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView = findViewById(R.id.loro);
        recyclerView.setHasFixedSize(true);
        mNewsItems = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();

    }

    private void parseJSON() {
        String url = "https://newsapi.org/v2/top-headlines?country=id&apiKey=40ffbc8acaf748698a35698d49a7b0cd";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("articles");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject resul = jsonArray.getJSONObject(i);
                        String judul = resul.getString("title");
                        String url = resul.getString("url");
                        String image = resul.getString("urlToImage");
                        String deskripsi = resul.getString("description");
                        String konten = resul.getString("content");
                        Item tambah = new Item(image, judul, deskripsi, url, konten);
                        mNewsItems.add(tambah);
                    }
                    mAdapter = new Adapter(ListActivity.this, mNewsItems);
                    mRecyclerView.setAdapter(mAdapter);
                    mAdapter.setOnItemClickListener(ListActivity.this);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent news = new Intent(this,DetailwebActivity.class);
        Item clickedItem = mNewsItems.get(position);

        news.putExtra(EXTRA_IMAGE,clickedItem.getGambar());
        news.putExtra(EXTRA_TITTLE,clickedItem.getTittle());
        news.putExtra(EXTRA_KONTEN,clickedItem.getKonten());
        news.putExtra(NEWS_URL,clickedItem.getUrl());
        startActivity(news);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
