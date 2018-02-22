package com.exmple.taimoor.thewayout.sportsactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.exmple.taimoor.thewayout.R;
import com.exmple.taimoor.thewayout.reservationactivities.ReservationActivity;
import com.exmple.taimoor.thewayout.sportsactivities.swimming.swimmingactivity;

public class SportsActivity extends AppCompatActivity {
    Button mswim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        mswim = (Button)findViewById(R.id.swim);
        mswim.setOnClickListener(swim);

    }
    public View.OnClickListener swim = new View.OnClickListener()
    {
        public void onClick (View v)
        {
            Intent intent = new Intent(SportsActivity.this, swimmingactivity.class);
            startActivity(intent);
        }
    };
}
