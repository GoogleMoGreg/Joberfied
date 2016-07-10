package com.chrs.iit.android.greg.joberfied;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Main_Description extends Fragment {

    private static final String ARG_LAYOUT_RESID="layoutResId";


    public static Main_Description newInstance(int layoutResId ){

        Main_Description main_description=new Main_Description();

        Bundle args=new Bundle();
        args.putInt(ARG_LAYOUT_RESID,layoutResId);
        main_description.setArguments(args);
        return main_description;

    }
    private int layoutResId;



    public Main_Description() {
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
        // Inflate the layout for this fragment
        return inflater.inflate(layoutResId, container, false);
    }

}
