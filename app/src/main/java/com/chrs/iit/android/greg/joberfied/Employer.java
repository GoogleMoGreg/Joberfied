package com.chrs.iit.android.greg.joberfied;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Employer extends AppCompatActivity implements View.OnClickListener{


    Button btn_login,btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);


        btn_login=(Button)findViewById(R.id.loginEmployer_btn);
        btn_login.setOnClickListener(this);
        btn_signup=(Button)findViewById(R.id.signupEmployer_btn);
        btn_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.loginEmployer_btn:

                break;

            case R.id.signupEmployer_btn:
                 ShowEmployerRegister();
                break;

        }
    }
    public void showEmployerMain(){

    }

    public void ShowEmployerRegister(){

        Intent showEmployerRegister=new Intent(this,Employer_Register.class);
        startActivity(showEmployerRegister);
    }
}
