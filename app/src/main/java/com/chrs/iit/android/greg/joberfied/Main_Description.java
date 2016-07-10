package com.chrs.iit.android.greg.joberfied;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Main_Description extends Fragment implements View.OnClickListener {

    private static final String ARG_LAYOUT_RESID="layoutResId";

    TextView tv_font_title,tv_main_descrp_message1,tv_main_descrp_message2,tv_main_descrp_message3,
            tv_main_descrp_message4,tv_main_descrp_message5,tv_main_descrp_message6,
            tv_main_descrp_message7,tv_main_descrp_message8,tv_main_descrp_message9,
            tv_main_descrp_message10,tv_main_descrp_message11,tv_main_descrp_message12,
            tv_main_descrp_message13,tv_main_descrp_message14;

    Typeface typeface;

    ImageView iv_twitter,iv_gallery,iv_retina,iv_responsive,iv_map,iv_browser;



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

    Animation rotate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(layoutResId, container, false);
        tv_font_title=(TextView)view.findViewById(R.id.tv_font_title);
        Typeface customfont=Typeface.createFromAsset(getActivity().getAssets(), "font_title.ttf");
        tv_font_title.setTypeface(customfont);

        tv_main_descrp_message1=(TextView)view.findViewById(R.id.tv_main_desc_message1);
        tv_main_descrp_message2=(TextView)view.findViewById(R.id.tv_main_desc_message2);
        tv_main_descrp_message3=(TextView)view.findViewById(R.id.tv_main_desc_message3);
        tv_main_descrp_message4=(TextView)view.findViewById(R.id.tv_main_desc_message4);
        tv_main_descrp_message5=(TextView)view.findViewById(R.id.tv_main_desc_message5);
        tv_main_descrp_message6=(TextView)view.findViewById(R.id.tv_main_desc_message6);
        tv_main_descrp_message7=(TextView)view.findViewById(R.id.tv_main_desc_message7);
        tv_main_descrp_message8=(TextView)view.findViewById(R.id.tv_main_desc_message8);
        tv_main_descrp_message9=(TextView)view.findViewById(R.id.tv_main_desc_message9);
        tv_main_descrp_message10=(TextView)view.findViewById(R.id.tv_main_desc_message10);
        tv_main_descrp_message11=(TextView)view.findViewById(R.id.tv_main_desc_message11);
        tv_main_descrp_message12=(TextView)view.findViewById(R.id.tv_main_desc_message12);
        tv_main_descrp_message13=(TextView)view.findViewById(R.id.tv_main_desc_message13);
        tv_main_descrp_message14=(TextView)view.findViewById(R.id.tv_main_desc_message14);

        typeface=Typeface.createFromAsset(getActivity().getAssets(),"VarelaRound-Regular.ttf");
        tv_main_descrp_message1.setTypeface(typeface);
        tv_main_descrp_message2.setTypeface(typeface);
        tv_main_descrp_message3.setTypeface(typeface);
        tv_main_descrp_message4.setTypeface(typeface);
        tv_main_descrp_message5.setTypeface(typeface);
        tv_main_descrp_message6.setTypeface(typeface);
        tv_main_descrp_message7.setTypeface(typeface);
        tv_main_descrp_message8.setTypeface(typeface);
        tv_main_descrp_message9.setTypeface(typeface);
        tv_main_descrp_message10.setTypeface(typeface);
        tv_main_descrp_message11.setTypeface(typeface);
        tv_main_descrp_message12.setTypeface(typeface);
        tv_main_descrp_message13.setTypeface(typeface);
        tv_main_descrp_message14.setTypeface(typeface);

        iv_browser=(ImageView)view.findViewById(R.id.iv_icon_browser);
        iv_browser.setOnClickListener(this);
        iv_gallery=(ImageView)view.findViewById(R.id.iv_icon_gallery);
        iv_gallery.setOnClickListener(this);
        iv_map=(ImageView)view.findViewById(R.id.iv_icon_map);
        iv_map.setOnClickListener(this);
        iv_responsive=(ImageView)view.findViewById(R.id.iv_icon_responsive);
        iv_responsive.setOnClickListener(this);
        iv_retina=(ImageView)view.findViewById(R.id.iv_icon_retina);
        iv_retina.setOnClickListener(this);
        iv_twitter=(ImageView)view.findViewById(R.id.iv_icon_twitter);
        iv_twitter.setOnClickListener(this);

        rotate= AnimationUtils.loadAnimation(getActivity(),R.anim.anim_rotate);


        return view;


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.iv_icon_browser:

                iv_browser.startAnimation(rotate);
                break;
            case R.id.iv_icon_map:

                iv_map.startAnimation(rotate);
                break;
            case R.id.iv_icon_gallery:

                iv_gallery.startAnimation(rotate);
                break;
            case R.id.iv_icon_responsive:

                iv_responsive.startAnimation(rotate);
                break;
            case R.id.iv_icon_retina:

                iv_retina.startAnimation(rotate);
                break;
            case R.id.iv_icon_twitter:

                iv_twitter.startAnimation(rotate);
                break;

        }
    }


}
