package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.abdulrhman.myapplication.backend.myApi.MyApi;
import com.example.android.andjoke.AndJokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Abdulrhman on 12/06/2017.
 */


public class JokeAsync extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;

    public JokeAsync(Context context) {
        mContext = context;
    }


    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

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

        Log.d("LOGRESULT", result);
        intent.putExtra(AndJokeActivity.JOKE_KEY, result);
        mContext.startActivity(intent);
    }
}

