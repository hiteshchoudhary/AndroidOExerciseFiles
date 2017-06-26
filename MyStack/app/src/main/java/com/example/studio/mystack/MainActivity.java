package com.example.studio.mystack;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public class SetupFetch extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {

            URL url;
            String page = "";
            HttpURLConnection urlConnection = null;


            try {
                url = new URL(strings[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream input = urlConnection.getInputStream();

                InputStreamReader read = new InputStreamReader(input);


                int data = read.read();

                while (data != -1){
                    char storeData = (char) data;
                    page += storeData;
                    data = read.read();
                }
                return page;


            }

            catch(Exception e) {
                e.printStackTrace();
                return "Cannot fetch web page";
            }




        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetupFetch request = new SetupFetch();

        String page = null;


        try {
            page = request.execute("http://www.HiteshChoudhary.com/").get();
            Log.i("DONE", "DONE");

        }
        catch (Exception e){
            e.printStackTrace();
        }

        Log.i("Stackoverflow", page);
        Log.i("DONE", "DONE");

    }
}















