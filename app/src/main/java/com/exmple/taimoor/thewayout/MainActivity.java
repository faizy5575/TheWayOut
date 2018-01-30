package com.exmple.taimoor.thewayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mUserName, mPassword;
    Button mloginButton,mregisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = (EditText) findViewById(R.id.txtUserName);
        mPassword = (EditText) findViewById(R.id.txtPassword);
        mloginButton = (Button) findViewById(R.id.loginButton);
        mloginButton.setOnClickListener(onLogin);
        mregisterButton = (Button) findViewById(R.id.registerButton);
        mregisterButton.setOnClickListener(Onregis);
    }

    public View.OnClickListener onLogin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String userName = mUserName.getText().toString();
            String password = mPassword.getText().toString();
            String type = "login";

            BackgroundWorker backgroundworker = new BackgroundWorker(MainActivity.this);
            backgroundworker.execute(type, userName, password);
        }
    };

    public View.OnClickListener Onregis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Registration.class);
            startActivity(intent);

        }
    };
}
