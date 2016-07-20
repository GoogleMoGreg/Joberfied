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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobSeekerAttache extends Fragment {


    public JobSeekerAttache() {
        // Required empty public constructor
    }

    private List<JobSeeker_AttacheClass>jobSeeker_attacheClassList=new ArrayList<>();
    private RecyclerView recyclerView;
    private JobSeeker_AttacheAdapter jobSeekerAttacheAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_employer_attache, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycle_view);

        jobSeekerAttacheAdapter=new JobSeeker_AttacheAdapter(jobSeeker_attacheClassList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(jobSeekerAttacheAdapter);
        prepareAds();
        return view;
    }

    public void prepareAds(){
        Log.e("MESSAGE: ","Preparing Ads...");

        JobSeeker_AttacheClass jobSeekerAttacheClass=new JobSeeker_AttacheClass("USRN Clinical Analsyt",
                "3 years related work Experience","Skills Required:CSS3,HTML5","REFER PHP(3,000)");
        jobSeeker_attacheClassList.add(jobSeekerAttacheClass);

        jobSeekerAttacheClass=new JobSeeker_AttacheClass("USRN Clinical Analsyt",
                "3 years related work Experience","Skills Required:CSS3,HTML5","REFER PHP(5,000)");
        jobSeeker_attacheClassList.add(jobSeekerAttacheClass);

        jobSeekerAttacheClass=new JobSeeker_AttacheClass("USRN Clinical Analsyt",
                "3 years related work Experience","Skills Required:CSS3,HTML5","REFER PHP(10,000)");
        jobSeeker_attacheClassList.add(jobSeekerAttacheClass);


    }


}
