package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.JokePoller;
import com.example.android.andjoke.AndJokeActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //used in the first required step, but it is not functioning any more
    public void tellJoke(View view) {

        JokePoller javaJoke = new JokePoller();
        Toast.makeText(this, javaJoke.getJoke(), Toast.LENGTH_SHORT).show();
        String joke = javaJoke.getJoke();
        Intent intentJoke = new Intent(this, AndJokeActivity.class);
        intentJoke.putExtra(getString(R.string.jokecode), joke);
        startActivity(intentJoke);
        JokeAsync myjokeAsync = new JokeAsync(MainActivity.this);
        myjokeAsync.execute();
    }






}
