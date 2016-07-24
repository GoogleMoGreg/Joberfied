package com.chrs.iit.android.greg.joberfied;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by greg on 7/20/16.
 */
public class JobSeeker_AttacheAdapter extends RecyclerView.Adapter<JobSeeker_AttacheAdapter.MyViewHolder> {


    private List<JobSeeker_AttacheClass>jobSeeker_attacheClassList;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView adsTitle,adsQualifications,adsSkills;
        Button btn_refer;
        RelativeLayout relativeLayoutBackground;
        RoundedImageView roundedImageView;


        public MyViewHolder(View view) {
            super(view);
            adsTitle=(TextView)view.findViewById(R.id.ads_title);
            adsQualifications=(TextView)view.findViewById(R.id.ads_qualifications_message);
            adsSkills=(TextView)view.findViewById(R.id.ads_skills);
            btn_refer=(Button)view.findViewById(R.id.refer_btn);
            relativeLayoutBackground=(RelativeLayout)view.findViewById(R.id.relative_Layout_background);
            roundedImageView=(RoundedImageView)view.findViewById(R.id.iv_company);
        }
    }

    public JobSeeker_AttacheAdapter(List<JobSeeker_AttacheClass> jobSeeker_attacheClassList,Context context) {
        this.jobSeeker_attacheClassList = jobSeeker_attacheClassList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext())
                                     .inflate(R.layout.jobseeker_attache_list,parent,false);

        return new MyViewHolder(itemView);
    }


    @Override
    public int getItemCount() {
        return jobSeeker_attacheClassList.size();
    }

    public void filter(List<JobSeeker_AttacheClass>list){
        jobSeeker_attacheClassList=new ArrayList<>();
        jobSeeker_attacheClassList.addAll(list);
        if(jobSeeker_attacheClassList.isEmpty()){

            JobSeekerAttache.tv_search_results.setVisibility(View.VISIBLE);

        }
        else {
            JobSeekerAttache.tv_search_results.setVisibility(View.GONE);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        JobSeeker_AttacheClass jobSeekerAttacheClass=jobSeeker_attacheClassList.get(position);
        holder.adsTitle.setText(jobSeekerAttacheClass.getAdsTitle());
        holder.adsQualifications.setText(jobSeekerAttacheClass.getAdsQualifications());
        holder.adsSkills.setText(jobSeekerAttacheClass.getAdsSkills());
        holder.btn_refer.setText(jobSeekerAttacheClass.getAdsRefer());
        holder.roundedImageView.setImageResource(jobSeekerAttacheClass.getAdsLogo());
        holder.relativeLayoutBackground.setBackgroundResource(jobSeekerAttacheClass.getAdsBackground());

    }


}
