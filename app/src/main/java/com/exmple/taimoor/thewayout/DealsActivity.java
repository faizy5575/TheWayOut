package com.exmple.taimoor.thewayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DealsActivity extends AppCompatActivity {
    Button mAddNewDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);
        mAddNewDeal = (Button) findViewById(R.id.addNewDeal);
        mAddNewDeal.setOnClickListener(onAddDeal);
    }

    public View.OnClickListener onAddDeal = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(DealsActivity.this, NewDeal.class);
            startActivity(intent);
        }
    };
}

