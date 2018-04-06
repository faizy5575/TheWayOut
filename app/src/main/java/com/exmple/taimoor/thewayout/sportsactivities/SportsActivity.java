package com.exmple.taimoor.thewayout.sportsactivities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.exmple.taimoor.thewayout.R;
import com.exmple.taimoor.thewayout.homeactivities.HomeActivity;
import com.exmple.taimoor.thewayout.homeactivities.LoginActivity;
import com.exmple.taimoor.thewayout.sportsactivities.Swimming.SwimmingActivity;

public class SportsActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    Button buttonSwimming;
    private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);


        buttonSwimming = (Button) findViewById(R.id.buttonSwimming);
        buttonSwimming.setOnClickListener(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mdrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this, mdrawerlayout, R.string.open, R.string.close);

        mdrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sports");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonSwimming) {
            startActivity(new Intent(SportsActivity.this, SwimmingActivity.class));
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_logout:
                SharedPreferences sharedPreferences = getSharedPreferences("mysharedpref12", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                editor.commit();
                finish();

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                item.setChecked(true);
                break;

            case R.id.nav_home:
                Intent intent1 = new Intent(this, HomeActivity.class);
                startActivity(intent1);
                finish();
                item.setChecked(true);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
