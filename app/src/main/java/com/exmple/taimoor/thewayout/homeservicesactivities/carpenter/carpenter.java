package com.exmple.taimoor.thewayout.homeservicesactivities.carpenter;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.ImageView;


import com.exmple.taimoor.thewayout.R;


public class carpenter extends Activity {

    ListView SubjectFullFormListView;
    ProgressBar progressBar;
    String HttpURL = "http://192.168.53.53:8080/theWayOut/carpenter.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_carpenter);

        SubjectFullFormListView = (ListView) findViewById(R.id.carpentListView);

        progressBar = (ProgressBar) findViewById(R.id.carpentProgressBar1);

        new ParseJSonDataClass(this).execute();
    }

    private class ParseJSonDataClass extends AsyncTask<Void, Void, Void> {
        public Context context;
        String FinalJSonResult;
        List<Subject> SubjectFullFormList;

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

                            SubjectFullFormList = new ArrayList<Subject>();

                            for (int i = 0; i < jsonArray.length(); i++) {

                                subject = new Subject();

                                jsonObject = jsonArray.getJSONObject(i);

                                subject.Subject_Name = jsonObject.getString("txt_name");

                                subject.Subject_Full_Form = jsonObject.getString("txt_address");

                                subject.Subject_Full_Form_PhoneNumber = jsonObject.getString("int_phoneNumber");

                                SubjectFullFormList.add(subject);
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

            SubjectFullFormListView.setVisibility(View.VISIBLE);

            if (SubjectFullFormList != null) {

                ListAdapter adapter = new ListAdapter(SubjectFullFormList, context);

                SubjectFullFormListView.setAdapter(adapter);
            }
        }
    }




}