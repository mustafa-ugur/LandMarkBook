package com.example.mustafaugur.landmarkbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap selecedImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.listView);

        final ArrayList<String> landMarkNames = new ArrayList<String>();
        landMarkNames.add("Gaziantep");
        landMarkNames.add("İzmir");
        landMarkNames.add("İstanbul");
        landMarkNames.add("Ankara");


        Bitmap antep = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.antep);
        Bitmap izmir = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.izmir);
        Bitmap istanbul = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.istanbul);
        Bitmap ankara = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ankara);


            final ArrayList<Bitmap> landmarkImage = new ArrayList<Bitmap>();
            landmarkImage.add(antep);
            landmarkImage.add(izmir);
            landmarkImage.add(istanbul);
            landmarkImage.add(ankara);


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, landMarkNames);

        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("name", landMarkNames.get(i));
                selecedImages = landmarkImage.get(i);
                startActivity(intent);
            }
        });

    }
}
