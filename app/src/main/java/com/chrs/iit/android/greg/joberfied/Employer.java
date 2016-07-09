package com.chrs.iit.android.greg.joberfied;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Employer extends AppCompatActivity implements View.OnClickListener{

    Button loginEmployer_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);

        loginEmployer_btn=(Button)findViewById(R.id.loginEmployer_btn);
        loginEmployer_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.loginEmployer_btn:
                showEmployerMain();
                break;
        }
    }
    public void showEmployerMain(){

        Intent showEmployerMainClass=new Intent(this,EmployerMain.class);
        startActivity(showEmployerMainClass);
    }
}
