package com.exmple.taimoor.thewayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeServices extends AppCompatActivity {
Button melect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_services);
        melect = (Button)findViewById(R.id.elect);
        melect.setOnClickListener(elect);
    }
    public View.OnClickListener elect = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent = new Intent(HomeServices.this, Electrician.class);
            startActivity(intent);
           }
    };

}
