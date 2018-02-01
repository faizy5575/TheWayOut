package com.exmple.taimoor.thewayout.homeactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.exmple.taimoor.thewayout.R;

public class Registration extends AppCompatActivity {
    EditText mName,mcnic,mAddress, mPassword ,mreEnteredPassword;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mName = (EditText) findViewById(R.id.et_name);
        mcnic = (EditText) findViewById(R.id.et_cnic);
        mAddress = (EditText) findViewById(R.id.et_address);
        mPassword = (EditText) findViewById(R.id.et_password);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(tell);
    }


    public View.OnClickListener tell = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String Name = mName.getText().toString();
            String CNIC = mcnic.getText().toString();
            String Address = mAddress.getText().toString();
            String Password = mPassword.getText().toString();
            String type = "Registration";

            BackgroundWorker backgroundworker = new BackgroundWorker(Registration.this);
            backgroundworker.execute(type, Name,CNIC,Address, Password);
        }
    };
//    public void onCheckboxClicked(View view) {
//        // Is the view now checked?
//        boolean checked = ((CheckBox) view).isChecked();
//
//        // Check which checkbox was clicked
//        switch (view.getId()) {
//            case R.id.chbox:
//                if (checked)
//                {
//
//                }
//                else
//                {
//
//                }
//                break;
//        }
//    }
}
