package com.exmple.taimoor.thewayout.homeactivities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.exmple.taimoor.thewayout.activitiesactivities.ActivitiesActivity;
import com.exmple.taimoor.thewayout.facilitiesactivities.FacilitiesActivity;
import com.exmple.taimoor.thewayout.R;
import com.exmple.taimoor.thewayout.sportsactivities.SportsActivity;
import com.exmple.taimoor.thewayout.dealsactivities.DealsActivity;
import com.exmple.taimoor.thewayout.directoryactivities.DirectoryActivity;
import com.exmple.taimoor.thewayout.homeservicesactivities.HomeServices;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mToggle;

    String arrayName[]= {"Sports", "Home Services", "Deals", "Activities", "Directory", "Facilities"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mdrawerlayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this, mdrawerlayout, R.string.open, R.string.close);

        mdrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        CircleMenu circleMenu = (CircleMenu)findViewById(R.id.circleMenu);
        circleMenu.setMainMenu(Color.parseColor("#91D8F7"), R.drawable.open1, R.drawable.close1)
                .addSubMenu(Color.parseColor("#A8CF45"), R.drawable.sports1)
                .addSubMenu(Color.parseColor("#A8CF45"), R.drawable.homeservices1)
                .addSubMenu(Color.parseColor("#A8CF45"), R.drawable.deals1)
                .addSubMenu(Color.parseColor("#A8CF45"), R.drawable.activities1)
                .addSubMenu(Color.parseColor("#A8CF45"), R.drawable.directory1)
                .addSubMenu(Color.parseColor("#A8CF45"), R.drawable.facilities1);

                circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        switch (index) {
                            case 0:
                                Toast.makeText(HomeActivity.this, "You Selected "+arrayName[index], Toast.LENGTH_SHORT).show();
                                Intent sports = new Intent(HomeActivity.this, SportsActivity.class);
                                startActivity(sports);
                                break;
                            case 1:
                                Toast.makeText(HomeActivity.this, "You Selected "+arrayName[index], Toast.LENGTH_SHORT).show();
                                Intent homeServices = new Intent(HomeActivity.this, HomeServices.class);
                                startActivity(homeServices);
                                break;
                            case 2:
                                Toast.makeText(HomeActivity.this, "You Selected "+arrayName[index], Toast.LENGTH_SHORT).show();
                                Intent deals = new Intent(HomeActivity.this, DealsActivity.class);
                                startActivity(deals);
                                break;
                            case 3:
                                Toast.makeText(HomeActivity.this, "You Selected "+arrayName[index], Toast.LENGTH_SHORT).show();
                                Intent activities = new Intent(HomeActivity.this, ActivitiesActivity.class);
                                startActivity(activities);
                                break;
                            case 4:
                                Toast.makeText(HomeActivity.this, "You Selected "+arrayName[index], Toast.LENGTH_SHORT).show();
                                Intent directory = new Intent(HomeActivity.this, DirectoryActivity.class);
                                startActivity(directory);
                                break;
                            case 5:
                                Toast.makeText(HomeActivity.this, "You Selected "+arrayName[index], Toast.LENGTH_SHORT).show();
                                Intent facilities = new Intent(HomeActivity.this, FacilitiesActivity.class);
                                startActivity(facilities);
                                break;
                            default:
                                Toast.makeText(HomeActivity.this, "You Selected nothing", Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.nav_logout:
                SharedPreferences sharedPreferences = getSharedPreferences("mysharedpref12", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                editor.commit();
                finish();

                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                item.setChecked(true);
                break;



        }
        return false;
    }
}
