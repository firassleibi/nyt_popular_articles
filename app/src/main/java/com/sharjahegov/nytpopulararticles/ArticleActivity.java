package com.sharjahegov.nytpopulararticles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ArticleActivity extends AppCompatActivity {
    ArticleData data;
    ImageView image;
    TextView subject;
    TextView description;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        image = findViewById(R.id.article_image);
        subject = findViewById(R.id.article_subject);
        description = findViewById(R.id.article_description);
        date = findViewById(R.id.article_date);
        data = (ArticleData) getIntent().getSerializableExtra("ArticleData");

        Picasso.with(this)
                .load(data.image)
                .into(image);
        subject.setText(data.subject);
        date.setText(data.date);
        description.setText(data.description);
    }
}
