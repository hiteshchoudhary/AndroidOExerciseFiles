package com.example.studio.volleytwo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    //https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Android_green_figure%2C_next_to_its_original_packaging.jpg/220px-Android_green_figure%2C_next_to_its_original_packaging.jpg


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String myURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Android_green_figure%2C_next_to_its_original_packaging.jpg/220px-Android_green_figure%2C_next_to_its_original_packaging.jpg";

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Button myButton = (Button) findViewById(R.id.button);


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageRequest imageRequest = new ImageRequest(myURL,
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap bitmap) {
                                imageView.setImageBitmap(bitmap);
                            }
                        }, 0, 0, null,
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Log.i("Error", "Error");
                            }
                        }
                );
                MySingleton.getInstance(MainActivity.this).addToRequestQue(imageRequest);
            }
        });



    }
}












