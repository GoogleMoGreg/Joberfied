package com.chrs.iit.android.greg.joberfied;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Employer extends AppCompatActivity implements View.OnClickListener{


    Button btn_login,btn_signup;
    EditText et_pin,et_pass;
    String pin,pass;
    //http://joberfied.com/api/employer/functions/auth.php?pin=1234-JJ&password=1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);

        et_pin=(EditText)findViewById(R.id.et_PinEmployer);
        et_pass=(EditText)findViewById(R.id.et_PassEmployer);
        btn_login=(Button)findViewById(R.id.loginEmployer_btn);
        btn_login.setOnClickListener(this);
        btn_signup=(Button)findViewById(R.id.signupEmployer_btn);
        btn_signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.loginEmployer_btn:
                 CheckLogin();
                break;

            case R.id.signupEmployer_btn:
                 ShowEmployerRegister();
                break;

        }
    }
    public void ShowEmployerMain(){
        Intent showEmployerMain=new Intent(this,EmployerMain.class);
        startActivity(showEmployerMain);
    }

    public void ShowEmployerRegister(){

        Intent showEmployerRegister=new Intent(this,Employer_Register.class);
        startActivity(showEmployerRegister);
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
                "http://joberfied.com/api/employer/functions/auth.php?pin="+pin+"&password="+pass+"",null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            String status=response.getString("status");
                            Log.e("MESSAGE STATUS: ",status);
                            if(status.equals("true")){

                                ShowEmployerMain();

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
