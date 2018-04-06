package com.exmple.taimoor.thewayout.sportsactivities.Swimming;



import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.exmple.taimoor.thewayout.R;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;


public class ActiveSwimmingPools extends AppCompatActivity {



    public static List<PlaceModel> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_active_swimming_pools);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerviewswimming);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        dataList.size();

        recyclerAdapter = new RecyclerAdapter(dataList, getApplicationContext());
        recyclerView.setAdapter(recyclerAdapter);

    }
}
