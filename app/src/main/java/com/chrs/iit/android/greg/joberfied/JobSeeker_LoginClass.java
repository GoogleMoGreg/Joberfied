package com.chrs.iit.android.greg.joberfied;

/**
 * Created by greg on 7/31/16.
 */
public class JobSeeker_LoginClass {

    String user_pin,
           user_pass;

    public JobSeeker_LoginClass(){

    }

    public JobSeeker_LoginClass(String user_pin, String user_pass) {
        this.user_pin = user_pin;
        this.user_pass = user_pass;
    }


    public String getUser_pin() {
        return user_pin;
    }

    public void setUser_pin(String user_pin) {
        this.user_pin = user_pin;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }
}
