package com.example.studio.stars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        final ArrayList<String> colour = new ArrayList<String>();

        colour.add("blue");
        colour.add("green");
        colour.add("red");
        colour.add("yellow");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,  android.R.layout.simple_list_item_1, colour);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), secondActivity.class);
                intent.putExtra("name", colour.get(position));
                startActivity(intent);

            }
        });



    }
}
