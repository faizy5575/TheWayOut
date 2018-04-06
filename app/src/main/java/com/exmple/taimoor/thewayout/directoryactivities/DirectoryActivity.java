package com.exmple.taimoor.thewayout.directoryactivities;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.toolbox.JsonArrayRequest;
import com.exmple.taimoor.thewayout.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class DirectoryActivity extends AppCompatActivity {

    ListView DirectoryListView;
    ProgressBar progressBar;
    String HttpURL = "http://192.168.53.118:80/theWayOut/directory.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_directory);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DirectoryListView = (ListView) findViewById(R.id.directoryListView1);

        progressBar = (ProgressBar) findViewById(R.id.ProgressBar1);

        new ParseJSonDataClass(this).execute();
    }

    private class ParseJSonDataClass extends AsyncTask<Void, Void, Void> {
        public Context context;
        String FinalJSonResult;
        List<Subject> DirectoryFullFormList;

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

                            DirectoryFullFormList = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {

                                subject = new Subject();

                                jsonObject = jsonArray.getJSONObject(i);

                                subject.userName = jsonObject.getString("txt_name");

                                subject.txt_address = jsonObject.getString("txt_address");

                                subject.int_phoneNumber = jsonObject.getString("int_phoneNumber");

                                DirectoryFullFormList.add(subject);
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

            DirectoryListView.setVisibility(View.VISIBLE);

            if (DirectoryFullFormList != null) {

                ListAdapter adapter = new ListAdapter(DirectoryFullFormList, context);

                DirectoryListView.setAdapter(adapter);
            }
        }
    }

}