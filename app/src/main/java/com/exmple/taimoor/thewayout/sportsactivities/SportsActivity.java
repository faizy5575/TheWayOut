package com.exmple.taimoor.thewayout.sportsactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.exmple.taimoor.thewayout.R;

public class SportsActivity extends AppCompatActivity {

    Button buttonSwimming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        buttonSwimming = (Button)findViewById(R.id.buttonSwimming);
    }
}
