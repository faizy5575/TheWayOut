package com.exmple.taimoor.thewayout.homeactivities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.exmple.taimoor.thewayout.ActivitiesActivity;
import com.exmple.taimoor.thewayout.FacilitiesActivity;
import com.exmple.taimoor.thewayout.R;
import com.exmple.taimoor.thewayout.ReservationActivity;
import com.exmple.taimoor.thewayout.SportsActivity;
import com.exmple.taimoor.thewayout.dealsactivities.DealsActivity;
import com.exmple.taimoor.thewayout.directoryactivities.DirectoryActivity;
import com.exmple.taimoor.thewayout.homeservicesactivities.HomeServices;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class HomeActivity extends AppCompatActivity {

    String arrayName[]= {"Sports", "Home Services", "Deals", "Activities", "Reservation", "Directory", "Facilities"};
    Button mLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mLogout = (Button)findViewById(R.id.logoutButton);
        mLogout.setOnClickListener(onLogout);

        CircleMenu circleMenu = (CircleMenu)findViewById(R.id.circleMenu);
        circleMenu.setMainMenu(Color.parseColor("#795548"), R.drawable.open1, R.drawable.close1)
                .addSubMenu(Color.parseColor("#9C27B0"), R.drawable.sports1)
                .addSubMenu(Color.parseColor("#009688"), R.drawable.homeservices1)
                .addSubMenu(Color.parseColor("#FFC107"), R.drawable.deals1)
                .addSubMenu(Color.parseColor("#E91E63"), R.drawable.activities1)
                .addSubMenu(Color.parseColor("#304FFE"), R.drawable.reservation1)
                .addSubMenu(Color.parseColor("#B2FF59"), R.drawable.directory1)
                .addSubMenu(Color.parseColor("#F44336"), R.drawable.facilities1);

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
                                Intent reservation = new Intent(HomeActivity.this, ReservationActivity.class);
                                startActivity(reservation);
                                break;
                            case 5:
                                Toast.makeText(HomeActivity.this, "You Selected "+arrayName[index], Toast.LENGTH_SHORT).show();
                                Intent directory = new Intent(HomeActivity.this, DirectoryActivity.class);
                                startActivity(directory);
                                break;
                            case 6:
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
    public View.OnClickListener onLogout = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            SharedPreferences sharedPreferences = getSharedPreferences("mysharedpref12", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            editor.commit();
            finish();

            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    };
}
