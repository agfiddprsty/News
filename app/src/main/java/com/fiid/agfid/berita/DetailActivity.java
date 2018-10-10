package com.fiid.agfid.berita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.fiid.agfid.berita.ListActivity.EXTRA_IMAGE;
import static com.fiid.agfid.berita.ListActivity.EXTRA_KONTEN;
import static com.fiid.agfid.berita.ListActivity.EXTRA_TITTLE;
import static com.fiid.agfid.berita.ListActivity.NEWS_URL;

public class DetailActivity extends AppCompatActivity {
    private TextView mjudul,mkonten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i = getIntent();
        String Url = i.getStringExtra(NEWS_URL);
        mjudul = findViewById(R.id.judul);
        mkonten = findViewById(R.id.konten);
        String judul = i.getStringExtra(EXTRA_TITTLE);
        String konten = i.getStringExtra(EXTRA_KONTEN);
        String foto = i.getStringExtra(EXTRA_IMAGE);
        mkonten.setText(konten);
        mjudul.setText(judul);
        ImageView mImageView = findViewById(R.id.image);
        Picasso.with(this).load(foto).fit().centerInside().into(mImageView);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}

