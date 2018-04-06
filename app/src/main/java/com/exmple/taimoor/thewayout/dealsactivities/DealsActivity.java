package com.exmple.taimoor.thewayout.dealsactivities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.exmple.taimoor.thewayout.R;
//import com.exmple.taimoor.thewayout.dealsactivities.DealsActivity;
//import com.exmple.taimoor.thewayout.directoryactivities.HttpServiceClass;
//import com.exmple.taimoor.thewayout.dealsactivities.ListAdapter;
//import com.exmple.taimoor.thewayout.directoryactivities.Subject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class DealsActivity extends AppCompatActivity {

    ListView DealsListView;
    ProgressBar progressBar;
    String HttpURL = "http://192.168.53.118:80/theWayOut/deals.php";
    Button mAddNewDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mAddNewDeal = (Button) findViewById(R.id.addNewDeal);
        mAddNewDeal.setOnClickListener(onAddDeal);

        DealsListView = (ListView) findViewById(R.id.dealsListView1);

        progressBar = (ProgressBar) findViewById(R.id.ProgressBar1);

        new ParseJSonDataClass(this).execute();
    }

    public View.OnClickListener onAddDeal = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(DealsActivity.this, NewDeal.class);
            startActivity(intent);
        }
    };


    private class ParseJSonDataClass extends AsyncTask<Void, Void, Void> {
        public Context context;
        String FinalJSonResult;
        List<Subject> DealsFullFormList;

        public ParseJSonDataClass(Context context) {

            this.context = context;
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            HttpServiceClass httpServiceClass = new HttpServiceClass(HttpURL);

            try {
                httpServiceClass.ExecutePostRequest();

                if (httpServiceClass.getResponseCode() == 200) {

                    FinalJSonResult = httpServiceClass.getResponse();

                    if (FinalJSonResult != null) {

                        JSONArray jsonArray = null;
                        try {

                            jsonArray = new JSONArray(FinalJSonResult);
                            JSONObject jsonObject;
                            Subject subject;

                            DealsFullFormList = new ArrayList<Subject>();

                            for (int i = 0; i < jsonArray.length(); i++) {

                                subject = new Subject();

                                jsonObject = jsonArray.getJSONObject(i);

                                subject.amount = jsonObject.getString("amount");

                                subject.image = jsonObject.getString("image");

                                subject.int_phoneNumber = jsonObject.getString("int_phoneNumber");

                                DealsFullFormList.add(subject);
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } else {

                    Toast.makeText(context, httpServiceClass.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)

        {
            progressBar.setVisibility(View.GONE);

            DealsListView.setVisibility(View.VISIBLE);

            if (DealsFullFormList != null) {

                ListAdapter adapter = new ListAdapter(DealsFullFormList, context);

                DealsListView.setAdapter(adapter);
            }
        }
    }

}


