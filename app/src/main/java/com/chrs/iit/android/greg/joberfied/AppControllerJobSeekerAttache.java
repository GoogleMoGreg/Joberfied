package com.chrs.iit.android.greg.joberfied;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by greg on 8/4/16.
 */
public class AppControllerJobSeekerAttache extends Application {

    public static final String TAG=AppControllerJobSeekerAttache.class.getSimpleName();

    private RequestQueue mRequestQueue;
    private static  AppControllerJobSeekerAttache mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }

    public static synchronized AppControllerJobSeekerAttache getInstance(){
        return mInstance;
    }
    public RequestQueue getRequest(){
        if(mRequestQueue==null){
            mRequestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag){
        req.setTag(TextUtils.isEmpty(tag)? TAG:tag);
        getRequest().add(req);
    }

    public <T> void addToRequestQueue(Request<T>req){
        req.setTag(TAG);
        getRequest().add(req);
    }

    public void cancelPendingRequest(Object tag){
        if(mRequestQueue !=null){
            mRequestQueue.cancelAll(tag);
        }
    }
}
