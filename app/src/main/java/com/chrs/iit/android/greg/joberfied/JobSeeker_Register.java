package com.chrs.iit.android.greg.joberfied;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JobSeeker_Register extends AppCompatActivity {


    private EditText et_lName, et_fName, et_email, et_pass, et_confirmPass;
    private Button btn_register;
    String fname,lname,email,pass,confirmpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker__register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_fName = (EditText) findViewById(R.id.et_jobseeker_fname);
        et_lName = (EditText) findViewById(R.id.et_jobseeker_lname);
        et_email = (EditText) findViewById(R.id.et_jobseeker_email);
        et_pass = (EditText) findViewById(R.id.et_jobseeker_pass);
        et_confirmPass = (EditText) findViewById(R.id.et_jobseeker_repeatpass);

        btn_register = (Button) findViewById(R.id.btn_jobseeker_confirm_reg);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });
    }

    public void SignUp() {
            Log.d("SignUp Acitivity","SIGNUP");


        final ProgressDialog progressDialog =new ProgressDialog(JobSeeker_Register.this);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Creating Account...");
                progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        if(!validate()){
                            progressDialog.dismiss();
                            Toast.makeText(getBaseContext(),"Login Failed",Toast.LENGTH_LONG).show();
                        }
                        else {
                            progressDialog.dismiss();
                            Toast.makeText(getBaseContext(),"Signup Success",Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }
                },3000);
        }

    public boolean validate () {

        boolean valid = true;

        fname = et_fName.getText().toString();
        lname = et_lName.getText().toString();
        email = et_email.getText().toString();
        pass = et_pass.getText().toString();
        confirmpass = et_confirmPass.getText().toString();

        if (fname.isEmpty() || fname.length() < 3) {
            et_fName.setError("Enter at least 3 characters");
            valid = false;
        }
        else {
            et_fName.setError(null);
        }

        if (lname.isEmpty() || lname.length() < 3) {
            et_lName.setError("Enter at least 3 characters");
            valid=false;
        }
        else {
            et_lName.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("Enter a valid email address");
            valid=false;
        }
        else {
            et_email.setError(null);
        }

        if(pass.isEmpty()){
            et_pass.setError("Invalid password");
            valid=false;
        }
        else {
            et_pass.setError(null);
        }
        if(!confirmpass.equals(pass)||confirmpass.isEmpty()){
            et_confirmPass.setError("Password does not match");
            valid=false;
        }
        else {
            et_confirmPass.setError(null);
        }

        return valid;
    }

    }

