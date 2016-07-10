package com.chrs.iit.android.greg.joberfied;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Employer extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.loginEmployer_btn:

                break;
        }
    }
    public void showEmployerMain(){


    }
}
