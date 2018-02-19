package com.exmple.taimoor.thewayout.homeservicesactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

public class HomeServices extends AppCompatActivity {
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
    }



