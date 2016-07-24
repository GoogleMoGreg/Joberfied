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
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

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
    public static TextView tv_search_results;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);


        final View view=inflater.inflate(R.layout.fragment_jobseeker_attache, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycle_view);
        tv_search_results=(TextView)view.findViewById(R.id.tv_search_results);
        jobSeekerAttacheAdapter=new JobSeeker_AttacheAdapter(jobSeeker_attacheClassList,getContext());

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(jobSeekerAttacheAdapter);
        prepareAds();

        JobSeekerMain.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("MESSAGE: ",query);
                final List<JobSeeker_AttacheClass>filteredList=filter(jobSeeker_attacheClassList,query);
                jobSeekerAttacheAdapter.filter(filteredList);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.e("MESSAGE: ",s);
                return true;
            }

            private List<JobSeeker_AttacheClass>filter(List<JobSeeker_AttacheClass>jobSeeker_attacheClassList,String query){
                    query=query.toLowerCase();
                final List<JobSeeker_AttacheClass>filteredList=new ArrayList<JobSeeker_AttacheClass>();
                for(JobSeeker_AttacheClass jobSeekerAttacheClass:jobSeeker_attacheClassList){
                    final String text=jobSeekerAttacheClass.getAdsTitle().toLowerCase();
                    if(text.contains(query)){
                        filteredList.add(jobSeekerAttacheClass);

                    }
                }

                return filteredList;
            }


        });


        return view;
    }

    public void prepareAds(){
        Log.e("MESSAGE: ","Preparing Ads...");

        JobSeeker_AttacheClass jobSeekerAttacheClass=new JobSeeker_AttacheClass("USRN Clinical Analsyt",
                "3 years related work Experience","Skills Required:CSS3,HTML5","REFER PHP(3,000)"
                ,R.drawable.accenture_sample,R.drawable.work2_sample);
        jobSeeker_attacheClassList.add(jobSeekerAttacheClass);

        jobSeekerAttacheClass=new JobSeeker_AttacheClass("USRN Clinical Analsyt",
                "3 years related work Experience","Skills Required:CSS3,HTML5","REFER PHP(5,000)"
                ,R.drawable.csscorp_sample,R.drawable.work3_sample);
        jobSeeker_attacheClassList.add(jobSeekerAttacheClass);

        jobSeekerAttacheClass=new JobSeeker_AttacheClass("USRN Clinical Analsyt",
                "3 years related work Experience","Skills Required:CSS3,HTML5","REFER PHP(10,000)"
                ,R.drawable.ibex_sample,R.drawable.work3_sample);
        jobSeeker_attacheClassList.add(jobSeekerAttacheClass);

        jobSeekerAttacheClass=new JobSeeker_AttacheClass("Game Developer",
                "3 years related work Experience","Skills Required:CSS3,HTML5","REFER PHP(10,000)"
                ,R.drawable.exl_sample,R.drawable.work4_sample);
        jobSeeker_attacheClassList.add(jobSeekerAttacheClass);

        jobSeekerAttacheClass=new JobSeeker_AttacheClass("Software Analyst",
                "3 years related work Experience","Skills Required:CSS3,HTML5","REFER PHP(10,000)"
                ,R.drawable.csscorp_sample,R.drawable.work_sample);
        jobSeeker_attacheClassList.add(jobSeekerAttacheClass);

        jobSeekerAttacheClass=new JobSeeker_AttacheClass("PHP Developer",
                "3 years related work Experience","Skills Required:CSS3,HTML5","REFER PHP(10,000)"
                ,R.drawable.innerworks_sample,R.drawable.work3_sample);
        jobSeeker_attacheClassList.add(jobSeekerAttacheClass);


    }


}
