package com.chrs.iit.android.greg.joberfied;

import android.content.Intent;

import com.android.volley.RequestQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JobSeeker extends AppCompatActivity implements View.OnClickListener {

    Button login_btn, signup_btn;
    EditText et_pin, et_pass;
    String pin, pass;
    DBSqliteHelper dbSqliteHelper;
    ArrayList<JobSeeker_LoginClass>jobSeeker_loginClassArrayList=new ArrayList<>();
    //http://joberfied.com/api/jobber/functions/auth.php?pin=1234-JJ&password=1 -->url login
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker);
        dbSqliteHelper=new DBSqliteHelper(this);

        et_pass = (EditText) findViewById(R.id.et_PassJobSeeker);
        et_pin = (EditText) findViewById(R.id.et_PinJobSeeker);
        login_btn = (Button) findViewById(R.id.loginjobSeeker_btn);
        login_btn.setOnClickListener(this);
        signup_btn = (Button) findViewById(R.id.signupjobSeeker_btn);
        signup_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.loginjobSeeker_btn:
                CheckLogin();

                break;
            case R.id.signupjobSeeker_btn:
                ShowJobseekerRegister();
                break;
        }
    }

    public void ShowJobseekerMain() {

        Intent showJobSeekerMain = new Intent(this, JobSeekerMain.class);
        startActivity(showJobSeekerMain);
        this.finish();
    }

    public void ShowJobseekerRegister() {

        Intent showJobseekerRegister = new Intent(this, JobSeeker_Register.class);
        startActivity(showJobseekerRegister);
    }

    public void CheckLogin() {
        pin = et_pin.getText().toString();
        pass = et_pass.getText().toString();

        if (pin.isEmpty() || pass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "INVALID DETAILS", Toast.LENGTH_SHORT).show();
        } else {
            makeJsonRequestLogin();
        }
    }

    public void makeJsonRequestLogin() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "http://joberfied.com/api/jobber/functions/auth.php?pin="+pin+"&password="+pass+"",null,
                 new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
            try {

                String status=response.getString("status");
                Log.e("MESSAGE STATUS: ",status);
                if(status.equals("true")){

                    ShowJobseekerMain();
                    dbSqliteHelper.addAccount(new JobSeeker_LoginClass(pin,pass));
                    for(JobSeeker_LoginClass j:jobSeeker_loginClassArrayList){
                        String dbTest="PIN: "+j.getUser_pin()+"\n"
                                        +"PASS: "+j.getUser_pass();
                        Log.e("MESSAGE: ",dbTest);
                    }
                }else if(status.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Account Does not Exist",Toast.LENGTH_LONG).show();
                }

            }catch (JSONException e){
                e.printStackTrace();
                Log.e("Error: ",e.getMessage());
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);


    }
}