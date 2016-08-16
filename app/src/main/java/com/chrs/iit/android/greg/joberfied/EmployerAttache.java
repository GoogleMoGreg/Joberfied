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
public class EmployerAttache extends Fragment {


    public EmployerAttache() {
        // Required empty public constructor
    }

    RecyclerView rv_employerAttacheList;
    List<Employer_AttacheClass> employer_attacheClassList=new ArrayList<>();
    Employer_AttacheAdapter employer_attacheAdapter;
    int[] employerImage={R.drawable.sample_female1,
                         R.drawable.sample_female2,
                         R.drawable.sample_female3,
                         R.drawable.eli_sample,
                         R.drawable.greg_sample,
                         R.drawable.rafael,
                         R.drawable.ken_sample,
                         R.drawable.tongue_sample,
                         R.drawable.happy_sample};
    int[]employerStatus={R.drawable.ic_online,
                         R.drawable.ic_offline
                        };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_employer_attache, container, false);
        rv_employerAttacheList=(RecyclerView)view.findViewById(R.id.rv_employer_attacheList);
        employer_attacheAdapter=new Employer_AttacheAdapter(employer_attacheClassList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        rv_employerAttacheList.setLayoutManager(layoutManager);
        rv_employerAttacheList.setItemAnimator(new DefaultItemAnimator());
        rv_employerAttacheList.setAdapter(employer_attacheAdapter);
        Log.e("PREPARING ITEMS: ","ADDING ITEMS");
        AddItems();
        return  view;
    }


    public void AddItems(){

        Employer_AttacheClass employer_attacheClass=new Employer_AttacheClass(employerImage[0],employerStatus[0],
                "- 123456 -","Programming Skills, Leadership Skills, Managerial Skills, Lab Works",false);
        employer_attacheClassList.add(employer_attacheClass);
        employer_attacheClass=new Employer_AttacheClass(employerImage[1],employerStatus[0],
                "- 123457 -","Programming Skills, Leadership Skills, Managerial Skills, Lab Works",false);
        employer_attacheClassList.add(employer_attacheClass);
        employer_attacheClass=new Employer_AttacheClass(employerImage[2],employerStatus[1],
                "- 1234T8 -","Programming Skills, Leadership Skills, Managerial Skills, Lab Works",false);
        employer_attacheClassList.add(employer_attacheClass);
        employer_attacheClass=new Employer_AttacheClass(employerImage[3],employerStatus[1],
                "- 1234A8 -","Programming Skills, Leadership Skills, Managerial Skills, Lab Works",false);
        employer_attacheClassList.add(employer_attacheClass);
        employer_attacheClass=new Employer_AttacheClass(employerImage[4],employerStatus[0],
                "- 1234B9 -","Programming Skills, Leadership Skills, Managerial Skills, Lab Works",false);
        employer_attacheClassList.add(employer_attacheClass);
        employer_attacheClass=new Employer_AttacheClass(employerImage[5],employerStatus[0],
                "- 1234C8 -","Programming Skills, Leadership Skills, Managerial Skills, Lab Works",false);
        employer_attacheClassList.add(employer_attacheClass);
        employer_attacheClass=new Employer_AttacheClass(employerImage[6],employerStatus[1],
                "- 1234D2 -","Programming Skills, Leadership Skills, Managerial Skills, Lab Works",false);
        employer_attacheClassList.add(employer_attacheClass);
        employer_attacheClass=new Employer_AttacheClass(employerImage[7],employerStatus[0],
                "- 1234E3 -","Programming Skills, Leadership Skills, Managerial Skills, Lab Works",false);
        employer_attacheClassList.add(employer_attacheClass);
        employer_attacheClass=new Employer_AttacheClass(employerImage[8],employerStatus[1],
                "- 1234F7 -","Programming Skills, Leadership Skills, Managerial Skills, Lab Works",false);
        employer_attacheClassList.add(employer_attacheClass);


    }

}
