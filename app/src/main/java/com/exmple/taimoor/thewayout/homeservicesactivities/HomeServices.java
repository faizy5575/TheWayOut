package com.exmple.taimoor.thewayout.homeservicesactivities;

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

import com.exmple.taimoor.thewayout.homeactivities.HomeActivity;
import com.exmple.taimoor.thewayout.homeactivities.LoginActivity;
import com.exmple.taimoor.thewayout.homeservicesactivities.construction.construction;
import com.exmple.taimoor.thewayout.homeservicesactivities.drivers.drivers;
import com.exmple.taimoor.thewayout.homeservicesactivities.glass_and_windows.glass_and_windows;
import com.exmple.taimoor.thewayout.homeservicesactivities.laundry.laundry;
import com.exmple.taimoor.thewayout.homeservicesactivities.cleaner.cleaner;
import com.exmple.taimoor.thewayout.homeservicesactivities.electrition.Electrician;
import com.exmple.taimoor.thewayout.R;
import com.exmple.taimoor.thewayout.homeservicesactivities.mason.mason;
import com.exmple.taimoor.thewayout.homeservicesactivities.plumber.plumber;
import com.exmple.taimoor.thewayout.homeservicesactivities.ac_technicians.ac_technicians;
import com.exmple.taimoor.thewayout.homeservicesactivities.painter.painter;
import com.exmple.taimoor.thewayout.homeservicesactivities.carpenter.carpenter;

public class HomeServices extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mToggle;
Button melect,mplumb,mlaund,mactech,mpaint,mcarpent,mclean,mmass,mglass,mdrive,mconstruct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_services);
        melect = (Button)findViewById(R.id.elect);
        melect.setOnClickListener(elect);
        mplumb=(Button)findViewById(R.id.plumb);
        mplumb.setOnClickListener(plumb);
        mlaund = (Button)findViewById(R.id.laund);
        mlaund.setOnClickListener(laund);
        mactech = (Button) findViewById(R.id.actech);
        mactech.setOnClickListener(actech);
        mpaint = (Button)findViewById(R.id.paint);
        mpaint.setOnClickListener(paint);
        mcarpent = (Button)findViewById(R.id.carPent);
        mcarpent.setOnClickListener(carpent);
        mclean = (Button)findViewById(R.id.clean);
        mclean.setOnClickListener(clean);
        mmass = (Button)findViewById(R.id.mass);
        mmass.setOnClickListener(mass);

        mglass = (Button)findViewById(R.id.glass);
        mglass.setOnClickListener(glass);

        mdrive = (Button)findViewById(R.id.drive);
        mdrive.setOnClickListener(drive);

        mconstruct = (Button)findViewById(R.id.construct);
        mconstruct.setOnClickListener(construct);



        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mdrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this, mdrawerlayout, R.string.open, R.string.close);

        mdrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home Services");

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

    public View.OnClickListener elect = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent = new Intent(HomeServices.this, Electrician.class);
            startActivity(intent);
           }
    };
    public View.OnClickListener plumb = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent = new Intent(HomeServices.this, plumber.class);
            startActivity(intent);
        }
    };
public View.OnClickListener laund = new View.OnClickListener()
{
    public void onClick(View v) {
        Intent intent = new Intent(HomeServices.this, laundry.class);
        startActivity(intent);
    }
};
public View.OnClickListener actech = new View.OnClickListener()
{
    public void onClick(View v)
    {
        Intent intent = new Intent(HomeServices.this, ac_technicians.class);
        startActivity(intent);
    }
};
public View.OnClickListener paint = new View.OnClickListener()
{
    public void onClick(View v)
    {
        Intent intent = new Intent(HomeServices.this, painter.class);
        startActivity(intent);
    }
};
    public View.OnClickListener carpent = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intent = new Intent(HomeServices.this, carpenter.class);
            startActivity(intent);
        }
    };
public View.OnClickListener clean = new View.OnClickListener()
{
    public void onClick(View v)
    {
        Intent intent = new Intent(HomeServices.this,cleaner.class);
        startActivity(intent);
    }
};
    public View.OnClickListener mass = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intend = new Intent(HomeServices.this,mason.class);
            startActivity(intend);

            }

        };
    public View.OnClickListener glass = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intend = new Intent(HomeServices.this, glass_and_windows.class);
            startActivity(intend);

        }

    };
    public View.OnClickListener drive = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intend = new Intent(HomeServices.this, drivers.class);
            startActivity(intend);

        }

    };
    public View.OnClickListener construct = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent intend = new Intent(HomeServices.this, construction.class);
            startActivity(intend);

        }

    };

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
        }

        return false;
    }
}



