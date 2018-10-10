package com.fiid.agfid.berita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import static com.fiid.agfid.berita.ListActivity.NEWS_URL;

public class DetailwebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailweb);
        Intent i = getIntent();
        String Url = i.getStringExtra(NEWS_URL);
        WebView web = (WebView)findViewById(R.id.webview);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(Url);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
