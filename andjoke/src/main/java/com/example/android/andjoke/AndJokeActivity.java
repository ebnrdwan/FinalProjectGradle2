package com.example.android.andjoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AndJokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY ="JOKE" ;
    TextView textView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_and_joke);
        Intent recJoke = getIntent();
        String joke = recJoke.getStringExtra("INTAG");


        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(joke);
    }
}
