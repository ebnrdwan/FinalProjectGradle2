package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.abdulrhman.myapplication.backend.myApi.MyApi;
import com.example.android.andjoke.AndJokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Abdulrhman on 12/06/2017.
 */


    public class jokeAsync extends AsyncTask<Void, Void, String> {
        private static MyApi myApiService = null;
        private Context mContext;

        public jokeAsync (Context context){
            mContext = context;
        }


        @Override
        protected String doInBackground(Void... params){
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://192.168.1.100:8080/_ah/api/");
                // end options for devappserver

                myApiService = builder.build();
            }

            try {
                return myApiService.recieveMyJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {

            Toast.makeText(mContext, result, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mContext, AndJokeActivity.class);

            intent.putExtra(AndJokeActivity.JOKE_KEY, result);
            mContext.startActivity(intent);
        }
    }

