package com.chrs.iit.android.greg.joberfied;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JobSeeker extends AppCompatActivity implements View.OnClickListener{

    Button login_btn,signup_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker);

        login_btn=(Button)findViewById(R.id.loginjobSeeker_btn);
        login_btn.setOnClickListener(this);
        signup_btn=(Button)findViewById(R.id.signupjobSeeker_btn);
        signup_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.loginjobSeeker_btn:
                ShowJobseekerMain();
                break;
            case R.id.signupjobSeeker_btn:
                ShowJobseekerRegister();
                break;
        }
    }

    public void ShowJobseekerMain(){

        Intent showJobSeekerMain=new Intent(this,JobSeekerMain.class);
        startActivity(showJobSeekerMain);
    }

    public void ShowJobseekerRegister(){

        Intent showJobseekerRegister=new Intent(this,JobSeeker_Register.class);
        startActivity(showJobseekerRegister);
    }
}
