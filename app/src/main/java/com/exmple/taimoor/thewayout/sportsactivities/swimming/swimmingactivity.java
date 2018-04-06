package com.exmple.taimoor.thewayout.sportsactivities.Swimming;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.exmple.taimoor.thewayout.R;
import com.exmple.taimoor.thewayout.homeactivities.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SwimmingActivity extends AppCompatActivity {


    private int hour, min;

    TextView txtdate, txtStarttime, txtEndtime;
    Button btnStarttime, btnEndtime, btndatepicker, checkAvailability;

    java.sql.Time timeValue;
    SimpleDateFormat format;
    Calendar c;
    int year, month, day;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swimming);

        c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        min = c.get(Calendar.MINUTE);

        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        txtdate = (TextView) findViewById(R.id.txtDate);
        txtStarttime = (TextView) findViewById(R.id.txtStartTime);
        txtEndtime = (TextView) findViewById(R.id.txtEndTime);


        btndatepicker = (Button) findViewById(R.id.btnDatePicker);
        btnStarttime = (Button) findViewById(R.id.btnStartTimePicker);
        btnEndtime = (Button)findViewById(R.id.btnEndTimePicker);
        checkAvailability = (Button)findViewById(R.id.btnCheck);

        progressDialog = new ProgressDialog(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btndatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date

                DatePickerDialog dd = new DatePickerDialog(SwimmingActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                try {
                                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                                    String dateInString = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                                    Date date = formatter.parse(dateInString);

                                    Date d = new Date();

                                    txtdate.setText(formatter.format(date).toString());

                                    //          formatter = new SimpleDateFormat("dd/MMM/yyyy");

                                    //          txtdate.setText(txtdate.getText().toString()+"\n"+formatter.format(date).toString());

                                    //          formatter = new SimpleDateFormat("dd-MM-yyyy");

                                    //         txtdate.setText(txtdate.getText().toString()+"\n"+formatter.format(date).toString());

                                    //         formatter = new SimpleDateFormat("dd.MMM.yyyy");

                                    //         txtdate.setText(txtdate.getText().toString()+"\n"+formatter.format(date).toString());

                                } catch (Exception ex) {

                                }


                            }
                        }, year, month, day);
                dd.show();
            }
        });
        btnStarttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TimePickerDialog td = new TimePickerDialog(SwimmingActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                try {
                                    String dtStart = String.valueOf(hourOfDay-24) + ":" + String.valueOf(minute);
                                    format = new SimpleDateFormat("hh:mm");

                                    timeValue = new java.sql.Time(format.parse(dtStart).getTime());
                                    txtStarttime.setText(String.valueOf(timeValue));
//                                    String amPm = hourOfDay % 12 + ":" + minute + " " + ((hourOfDay >= 12) ? "PM" : "AM");
//                                         txtStarttime.setText(amPm + "\n" + String.valueOf(timeValue));
                                } catch (Exception ex) {
                                    txtStarttime.setText(ex.getMessage().toString());
                                }
                            }
                        },
                        hour, min,
                        DateFormat.is24HourFormat(SwimmingActivity.this)
                );
                td.show();





//                final Calendar c = Calendar.getInstance();
//                hour = c.get(Calendar.HOUR_OF_DAY);
//                min = c.get(Calendar.MINUTE);
//
//                // Launch Time Picker Dialog
//                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
//                        new TimePickerDialog.OnTimeSetListener() {
//
//                            @Override
//                            public void onTimeSet(TimePicker view, int hourOfDay,
//                                                  int minute) {
//
//                                txtStarttime.setText(hourOfDay + ":" + minute);
//                            }
//                        }, hour, min, false);
//                timePickerDialog.show();


            }
        });

        btnEndtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TimePickerDialog td = new TimePickerDialog(SwimmingActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                try {
                                    String dtStart = String.valueOf(hourOfDay-24) + ":" + String.valueOf(minute)+ ":00" ;
                                    format = new SimpleDateFormat("hh:mm:ss");

                                    timeValue = new java.sql.Time(format.parse(dtStart).getTime());
                                    txtEndtime.setText(String.valueOf(timeValue));
//                                    String amPm = hourOfDay % 12 + ":" + minute + " " + ((hourOfDay >= 12) ? "PM" : "AM");
//                                         txtEndtime.setText(amPm + "\n" + String.valueOf(timeValue));
                                } catch (Exception ex) {
                                    txtEndtime.setText(ex.getMessage().toString());
                                }
                            }
                        },
                        hour, min,
                        DateFormat.is24HourFormat(SwimmingActivity.this)
                );
                td.show();
            }
        });

        checkAvailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dateTimeCheck();


            }
        });

    }

    private void dateTimeCheck() {

            final String date = txtdate.getText().toString().trim();
            final String startTime = txtStarttime.getText().toString().trim();
            final String endTime = txtEndtime.getText().toString().trim();



            String mJSONURLString = Constants.URL_CHECKSWIMMING+"?item_type=checkAvailability&dte_date="+date+"&b_start_time="+startTime+"&b_end_time="+endTime;


         JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                mJSONURLString,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        progressDialog.setMessage("Checking Availability");
                        progressDialog.show();


                        ActiveSwimmingPools.dataList  = new ArrayList<>();

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonobject = null;
                            try {
                                jsonobject = response.getJSONObject(i);
                                String name = jsonobject.getString("sp_name");
                                String location = jsonobject.getString("sp_location");
                                PlaceModel placeModel = new PlaceModel();
                                placeModel.setName(name);
                                placeModel.setLocation(location);

                                ActiveSwimmingPools.dataList.add(placeModel);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        
                        progressDialog.dismiss();
                        Intent intent = new Intent(SwimmingActivity.this, ActiveSwimmingPools.class);
                        startActivity(intent);


                       JSONArray response_data = response;

                        try {
                            System.out.print(response_data.get(0).toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        System.out.print(error.toString());

                    }
                }
        );


        RequestHandler.getInstance(this).addToRequestQueue(jsonArrayRequest);



    }
}
