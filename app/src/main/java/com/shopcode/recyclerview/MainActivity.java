package com.shopcode.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize
        rv = findViewById(R.id.rv);

        //Set dummy data
        ArrayList<Map> partner_maps = new ArrayList<>();
        for(int i =0; i < 10; i++)
        {
            Map map = new HashMap();
            map.put("name", "Name "+String.valueOf(i+1));
            map.put("area", "Area "+String.valueOf(i+1));
            partner_maps.add(map);
        }

        //Set RecyclerView's orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(linearLayoutManager);

        //Pass data to the adapter
        partners_rv_adapter adapter = new partners_rv_adapter(this, R.layout.rv_element, partner_maps);
        rv.setAdapter(adapter);


    }
}