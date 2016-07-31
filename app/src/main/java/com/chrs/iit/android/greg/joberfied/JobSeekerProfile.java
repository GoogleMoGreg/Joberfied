package com.chrs.iit.android.greg.joberfied;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobSeekerProfile extends Fragment {


    public JobSeekerProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the jobseeker_attache_jobslist for this fragment
        return inflater.inflate(R.layout.fragment_jobseeker_profile, container, false);
    }

}
