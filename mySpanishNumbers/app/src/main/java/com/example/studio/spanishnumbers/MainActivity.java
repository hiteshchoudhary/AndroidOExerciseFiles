package com.example.studio.spanishnumbers;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void playMusic(View view){
        int id = view.getId();
        Log.i("ID", "ID value is " + id);

        String nameID;
        nameID = view.getResources().getResourceEntryName(id);

        Log.i("nameID", "my NAME ID IS: " + nameID);

        int myMusic = getResources().getIdentifier(nameID, "raw", "com.example.studio.spanishnumbers");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, myMusic);
        mediaPlayer.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
