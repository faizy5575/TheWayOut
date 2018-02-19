package com.exmple.taimoor.thewayout.homeactivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.exmple.taimoor.thewayout.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername, editTextPassword, editTextAddress, editTextCNIC, editTextPhone;
    private CheckBox checkBoxStatus;
    private TextView textViewLogin;
    private Button buttonRegister;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeActivity.class));
            return;
        }

        editTextUsername = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextCNIC = (EditText) findViewById(R.id.editTextCNIC);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);

        checkBoxStatus = (CheckBox)findViewById(R.id.checkBoxStatus);


        buttonRegister = (Button)findViewById(R.id.buttonRegister);
        buttonRegister.setEnabled(false);
        textViewLogin = (TextView)findViewById(R.id.textViewLogin);


        editTextUsername.addTextChangedListener(watcher);
        editTextPassword.addTextChangedListener(watcher);
        editTextAddress.addTextChangedListener(watcher);
        editTextCNIC.addTextChangedListener(watcher);
        editTextPhone.addTextChangedListener(watcher);


        progressDialog = new ProgressDialog(this);

        buttonRegister.setOnClickListener(this);
        textViewLogin.setOnClickListener(this);


    }

    private void registerUser() {
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String address = editTextAddress.getText().toString().trim();
        final String CNIC = editTextCNIC.getText().toString().trim();
        final String phone = editTextPhone.getText().toString().trim();
        final String status ;

        if (checkBoxStatus.isChecked())
        {
            status = "1";
        } else {
            status = "0";
        }


        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();


                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                            finish();
                            startActivity(intent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("txt_name", username);
                params.put("txt_password", password);
                params.put("txt_address", address);
                params.put("int_CNIC", CNIC);
                params.put("int_phoneNumber", phone);
                params.put("bl_status", status);


                return params;
            }
        };


        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);


    }

    @Override
    public void onClick(View view) {
        if (view == buttonRegister)
            registerUser();
        if (view == textViewLogin)
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        { }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {}
        @Override
        public void afterTextChanged(Editable s) {
            if (editTextUsername.getText().toString().trim().length() == 0 || editTextPassword.getText().toString().trim().length() == 0 ||
                    editTextAddress.getText().toString().trim().length() == 0 || editTextCNIC.getText().toString().trim().length() == 0 ||
                    editTextPhone.getText().toString().trim().length() == 0) {
                buttonRegister.setEnabled(false);
            } else {
                buttonRegister.setEnabled(true);
            }
        }

        };
}