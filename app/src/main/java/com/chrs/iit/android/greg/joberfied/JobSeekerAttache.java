package com.chrs.iit.android.greg.joberfied;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

//http://joberfied.com/api/jobber/functions/feeds.php?pin=c19ae400592f0d3fa8cb26f19bc76651--URL FEEDS
public class JobSeekerAttache extends Fragment {


    public JobSeekerAttache() {
        // Required empty public constructor
    }

    List<JobSeeker_AttacheClass>jobSeeker_attacheClassList=new ArrayList<>();

    private RecyclerView recyclerView;
    private JobSeeker_AttacheAdapter jobSeekerAttacheAdapter;
    public static TextView tv_search_results;
    private String URL_TAG="http://joberfied.com/api/jobber/functions/feeds.php?pin=c19ae400592f0d3fa8cb26f19bc76651";
    String FeedList,type_opt,jsonAds,jsonJobs,jsonVids;
    String opt;
    String test;
    JobSeeker_AttacheClass jClass;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the jobseeker_attache_jobslist for this fragment
        setHasOptionsMenu(true);


        final View view=inflater.inflate(R.layout.fragment_jobseeker_attache, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycle_view);
        tv_search_results=(TextView)view.findViewById(R.id.tv_search_results);
        jobSeekerAttacheAdapter=new JobSeeker_AttacheAdapter(jobSeeker_attacheClassList,getContext());

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        jobSeekerAttacheAdapter=new JobSeeker_AttacheAdapter(jobSeeker_attacheClassList,getContext());
        makeJSONRequest();
        recyclerView.setAdapter(jobSeekerAttacheAdapter);
        jobSeekerAttacheAdapter.notifyDataSetChanged();


        return view;
    }

    public void makeJSONRequest() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Request.Method.GET,URL_TAG,
                null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

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
                    for(JobSeeker_AttacheClass jClass:jobSeeker_attacheClassList){
                        opt=jClass.getFeeds_type();
                        switch (opt){
                            case "ads":
                                test="Title: "+jClass.getAds_Title()+"\n"
                                        +"Required_Skills: "+jClass.getAds_Reqd_Skills()+"\n"
                                        +"Years_Experience: "+jClass.getAds_YearsExp()+"\n";
                                break;
                            case "job":
                                test="Requirements: "+jClass.getJobs_Reqs()+"\n"
                                        +"Qualifications: "+jClass.getJobs_Qualifications()+"\n"
                                        +"Required Skills: "+jClass.getJobs_ReqdSkills()+"\n"
                                        +"Years of Experience: "+jClass.getJobs_YearsExp()+"\n";
                                break;
                            case "video":
                                test="Links: "+jClass.getVids_Links()+"\n"
                                        +"Tags: "+jClass.getVids_Tags()+"\n"
                                        +"Title: "+jClass.getVids_Title()+"\n"
                                        +"Description: "+jClass.getVids_Descrip()+"\n";
                                break;
                        }

                        FeedList+="PK: "+jClass.getFeeds_pk()+"\n"
                                +"TYPE: "+jClass.getFeeds_type()+"\n"+
                                test+"\n";
                    }
                    Log.e("MESSAGE: ",FeedList);

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonObjectRequest);
    }


    public void ParseJSONAds(String jsonAds,JobSeeker_AttacheClass jClass){

        try {
            JSONObject jsonObject = new JSONObject(jsonAds);
            jClass.ads_Title=jsonObject.getString("title");
            jClass.ads_Reqd_Skills=jsonObject.getString("required_skills");
            jClass.ads_YearsExp=jsonObject.getString("years_experience");
        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    public void ParseJSONJobs(String jsonJobs,JobSeeker_AttacheClass jClass){

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

    public void ParseJSONVids(String jsonVids,JobSeeker_AttacheClass jClass){

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

}