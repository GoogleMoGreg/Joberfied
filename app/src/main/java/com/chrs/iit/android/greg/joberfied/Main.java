package com.chrs.iit.android.greg.joberfied;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



/**
 * A simple {@link Fragment} subclass.
 */
public class Main extends Fragment implements View.OnClickListener {

    ImageView iv_jobseeker,iv_employer;


    private static final String ARG_LAYOUT_RESID="layoutResId";


    public static Main newInstance(int layoutResId ){

        Main main=new Main();

        Bundle args=new Bundle();
        args.putInt(ARG_LAYOUT_RESID,layoutResId);
        main.setArguments(args);
        return main;

    }
    private int layoutResId;

    public Main() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null&& getArguments().containsKey(ARG_LAYOUT_RESID))
            layoutResId=getArguments().getInt(ARG_LAYOUT_RESID);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the jobseeker_attache_jobslist for this fragment
        View view=inflater.inflate(layoutResId, container, false);

        iv_jobseeker=(ImageView)view.findViewById(R.id.iv_jobSeeker);
        iv_jobseeker.setOnClickListener(this);
        iv_employer=(ImageView)view.findViewById(R.id.iv_employer);
        iv_employer.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.iv_jobSeeker:
                Intent showJobseeker =new Intent(getActivity(),JobSeeker.class);
                startActivity(showJobseeker);
                break;
            case R.id.iv_employer:
                Intent showEmployer=new Intent(getActivity(),Employer.class);
                startActivity(showEmployer);
                break;
        }
    }







}
