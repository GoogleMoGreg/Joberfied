package com.chrs.iit.android.greg.joberfied;



import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import pl.droidsonroids.gif.GifImageView;


/**
 * A simple {@link Fragment} subclass.
 */

//http://joberfied.com/api/jobber/functions/feeds.php?pin=c19ae400592f0d3fa8cb26f19bc76651--URL FEEDS
public class JobSeekerAttache extends Fragment implements View.OnClickListener {


    public JobSeekerAttache() {
        // Required empty public constructor
    }

    private List<JobSeeker_AttacheClass>jobSeeker_attacheClassList;
    private RecyclerView recyclerView;
    private JobSeeker_AttacheAdapter jobSeekerAttacheAdapter;
    public static TextView tv_search_results;
    private String URL_TAG="http://joberfied.com/api/jobber/functions/feeds.php?pin=c19ae400592f0d3fa8cb26f19bc76651";
    String type_opt,jsonAds,jsonJobs,jsonVids;
    JobSeeker_AttacheClass jClass;
    private GifImageView iv_jobSeekerAttacheLoading;
    private TextView tv_personalInfoPopUp;
    private RelativeLayout rl_personalInfo;
    private PopupWindow popupWindow;


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_popUpPersonalInfo:
                Log.e("MESSAGE: ","CLICKED Personal Info");
                PopUpPersonalInfo(view);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the jobseeker_attache_jobslist for this fragment
        Log.e("MESSAGE: ","CALLING ATTACHE");
        View view=inflater.inflate(R.layout.fragment_jobseeker_attache, container, false);
        jobSeeker_attacheClassList=new ArrayList<JobSeeker_AttacheClass>();
        iv_jobSeekerAttacheLoading=(GifImageView)view.findViewById(R.id.iv_jobSeekerLoading);
        tv_personalInfoPopUp=(TextView)view.findViewById(R.id.tv_popUpPersonalInfo);
        tv_personalInfoPopUp.setPaintFlags(tv_personalInfoPopUp.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        rl_personalInfo=(RelativeLayout)view.findViewById(R.id.relativeLayout_jobSeekerPersonalInfo);
        tv_personalInfoPopUp.setOnClickListener(this);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycle_view);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        tv_search_results=(TextView)view.findViewById(R.id.tv_search_results);
        jobSeekerAttacheAdapter=new JobSeeker_AttacheAdapter(jobSeeker_attacheClassList,getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(jobSeekerAttacheAdapter);
        Log.e("MESSAGE: ","CALLING VOLLEY REQUEST");
        makeJSONRequest();




        return view;
    }

    public void makeJSONRequest() {
        rl_personalInfo.setVisibility(View.INVISIBLE);
        iv_jobSeekerAttacheLoading.setVisibility(View.VISIBLE);
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        Cache cache= requestQueue.getCache();
               //AppControllerJobSeekerAttache.getInstance().getRequest().getCache();
        Cache.Entry entry =cache.get(URL_TAG);
        if(entry!=null){
            try {
                String data=new String(entry.data,"UTF-8");
                try {
                    ParseJsonFeed(new JSONObject(data));
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }else {


            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_TAG,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                        if (response!=null){
                            ParseJsonFeed(response);
                        }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

          requestQueue.add(jsonObjectRequest);
       // AppControllerJobSeekerAttache.getInstance().addToRequestQueue(jsonObjectRequest);
        }
    }

    private void ParseJsonFeed(JSONObject response){
        try {

            JSONArray jsonArray=response.getJSONArray("result");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jObject=jsonArray.getJSONObject(i);
                jClass=new JobSeeker_AttacheClass();
                jClass.feeds_pk=jObject.getString("pk");
                jClass.feeds_type=jObject.getString("type");
                type_opt=jClass.getFeeds_type();
                switch (type_opt){
                    case "ads":
                        jClass.feeds_detailsAds=jObject.getString("details");
                        jsonAds=jClass.getFeeds_detailsAds();
                        ParseJSONAds(jsonAds,jClass);
                        break;
                    case "job":
                        jClass.feeds_detailsJobs=jObject.getString("details");
                        jsonJobs=jClass.getFeeds_detailsJobs();
                        ParseJSONJobs(jsonJobs,jClass);
                        break;
                    case "video":
                        jClass.feeds_detailsVids=jObject.getString("details");
                        jsonVids=jClass.getFeeds_detailsVids();
                        ParseJSONVids(jsonVids,jClass);
                        break;
                }
                jClass.feeds_dateCreated=jObject.getString("date_created");
                jobSeeker_attacheClassList.add(jClass);
            }
            iv_jobSeekerAttacheLoading.setVisibility(View.INVISIBLE);
            jobSeekerAttacheAdapter.notifyDataSetChanged();
            rl_personalInfo.setVisibility(View.VISIBLE);

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void ParseJSONAds(String jsonAds,JobSeeker_AttacheClass jClass){

        try {
            JSONObject jsonObject = new JSONObject(jsonAds);
            jClass.ads_Title=jsonObject.getString("title");
            jClass.ads_Reqd_Skills=jsonObject.getString("required_skills");
            jClass.ads_YearsExp=jsonObject.getString("years_experience");
        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    private void ParseJSONJobs(String jsonJobs,JobSeeker_AttacheClass jClass){

        try {
            JSONObject jsonObject = new JSONObject(jsonJobs);
            jClass.jobs_Reqs=jsonObject.getString("requirements");
            jClass.jobs_ReqdSkills=jsonObject.getString("qualifications");
            jClass.jobs_Qualifications =jsonObject.getString("required_skills");
            jClass.jobs_YearsExp=jsonObject.getString("years_experience");
        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    private void ParseJSONVids(String jsonVids,JobSeeker_AttacheClass jClass){

        try {
            JSONObject jsonObject = new JSONObject(jsonVids);
            jClass.vids_Links=jsonObject.getString("link");
            jClass.vids_Tags=jsonObject.getString("tags");
            jClass.vids_Title =jsonObject.getString("title");
            jClass.vids_Descrip=jsonObject.getString("description");
        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    private void PopUpPersonalInfo(View v){
            Log.e("MESSAGE: ","VIEW POP IN");
           LayoutInflater layoutInflater=(LayoutInflater)getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View inflatedView=layoutInflater.inflate(R.layout.jobseeker_popview_personal_information,null,false);
            Button btn_closePopUp;
            Display display=getActivity().getWindowManager().getDefaultDisplay();
            final Point size=new Point();
            display.getSize(size);
            btn_closePopUp=(Button)inflatedView.findViewById(R.id.btn_closePopViewPersonalInfo);
            //int screenHeight=getResources().getDisplayMetrics().heightPixels;
            //int screenWidth=getResources().getDis
        // playMetrics().widthPixels;

            popupWindow=new PopupWindow(inflatedView, RelativeLayout.LayoutParams.MATCH_PARENT, size.y-400);
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
            popupWindow.showAtLocation(inflatedView, Gravity.BOTTOM,0,100);
            btn_closePopUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("MESSAGE: ","CLICKED CLOSE POPUPWINDOW");
                    popupWindow.dismiss();
                }
            });


        }

    }



///------------------------------------------------------------------------------------------------
/*;*/