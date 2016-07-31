package com.chrs.iit.android.greg.joberfied;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * Created by greg on 7/20/16.
 */
public class JobSeeker_AttacheAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<JobSeeker_AttacheClass>jobSeeker_attacheClassList;
    private Context context;
    private String ADS="ads",JOBS="job",VIDS="video";
    public static final int Feeds_Ads=0,Feeds_Jobs=1,Feeds_Vids=2;

    String test;


    public JobSeeker_AttacheAdapter(List<JobSeeker_AttacheClass> jobSeeker_attacheClassList, Context context) {

        this.jobSeeker_attacheClassList = jobSeeker_attacheClassList;
        this.context = context;
    }


    RecyclerView.ViewHolder viewHolder;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        String testview=String.valueOf(viewType);
        for(JobSeeker_AttacheClass jClass:jobSeeker_attacheClassList){
            test+=jClass.getFeeds_type();
        }
      Log.e("ADAPTER TEST: ", test+"CHOICE: "+testview);

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            switch (viewType){
                case Feeds_Ads:
                    View viewAds=inflater.inflate(R.layout.jobseeker_attache_adslist,parent,false);
                    Log.e("INFLATING: ","ADS");
                    viewHolder=new ViewHolderAds(viewAds);
                   break;
                case Feeds_Jobs:
                    View viewJobs=inflater.inflate(R.layout.jobseeker_attache_jobslist,parent,false);
                    Log.e("INFLATING: ","JOBS");
                    viewHolder=new ViewHolderJobs(viewJobs);
                    break;
                case Feeds_Vids:
                    View viewVids=inflater.inflate(R.layout.jobseeker_attache_vidslist,parent,false);
                    Log.e("INFLATING: ","VIDS");
                    viewHolder=new ViewHolderVids(viewVids);
                    break;
            }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.e("ITEMVIEWTYPE BINDVIEW: ",String.valueOf(holder.getItemViewType()));

        switch (holder.getItemViewType()){

            case Feeds_Ads:
                ViewHolderAds viewHolderAds=(ViewHolderAds)holder;
                configureViewHolderAds(viewHolderAds,position);
               break;

            case Feeds_Jobs:
                ViewHolderJobs viewHolderJobs=(ViewHolderJobs)holder;
                configureViewHolderJobs(viewHolderJobs,position);
                break;

            case Feeds_Vids:
                ViewHolderVids viewHolderVids=(ViewHolderVids)holder;
                configureViewHolderVids(viewHolderVids,position);
                break;
        }


    }

    private void configureViewHolderAds(ViewHolderAds viewHolder,int position){
        JobSeeker_AttacheClass jobSeekerAttacheClass=jobSeeker_attacheClassList.get(position);
        viewHolder.tv_feedsTypeAds.setText(jobSeekerAttacheClass.getFeeds_type());
        viewHolder.tv_adsTitle.setText(jobSeekerAttacheClass.getAds_Title());
        viewHolder.tv_adsSkills.setText(jobSeekerAttacheClass.getAds_Reqd_Skills());
        viewHolder.tv_adsYearsExpi.setText(jobSeekerAttacheClass.getAds_YearsExp());
        viewHolder.tv_adsDateCreated.setText(jobSeekerAttacheClass.getAds_YearsExp());

   }

    private void configureViewHolderJobs(ViewHolderJobs viewHolder,int position){
        JobSeeker_AttacheClass jobSeekerAttacheClass=jobSeeker_attacheClassList.get(position);
        viewHolder.tv_feedsTypeJobs.setText(jobSeekerAttacheClass.getFeeds_type());
        viewHolder.tv_jobsDateCreated.setText(jobSeekerAttacheClass.getFeeds_dateCreated());
        viewHolder.tv_jobsQualifications.setText(jobSeekerAttacheClass.getJobs_Qualifications());
        viewHolder.tv_jobsReqdSkills.setText(jobSeekerAttacheClass.getJobs_ReqdSkills());
        viewHolder.tv_jobsRequirements.setText(jobSeekerAttacheClass.getJobs_Reqs());
        viewHolder.tv_jobsYearsExpi.setText(jobSeekerAttacheClass.getJobs_YearsExp());

    }

    private void configureViewHolderVids(ViewHolderVids viewHolder,int position){
        JobSeeker_AttacheClass jobSeekerAttacheClass=jobSeeker_attacheClassList.get(position);
        viewHolder.tv_feedsTypeVids.setText(jobSeekerAttacheClass.getFeeds_type());
        viewHolder.tv_vidsDateCreated.setText(jobSeekerAttacheClass.getFeeds_dateCreated());
        viewHolder.tv_vidsDescription.setText(jobSeekerAttacheClass.getVids_Descrip());
        viewHolder.tv_vidsLinks.setText(jobSeekerAttacheClass.getVids_Links());
        viewHolder.tv_vidsTags.setText(jobSeekerAttacheClass.getVids_Tags());
        viewHolder.tv_vidsTitle.setText(jobSeekerAttacheClass.getVids_Title());

    }

    @Override

    public int getItemCount() {
        return this.jobSeeker_attacheClassList.size();
    }

    String newTest;

    @Override
    public int getItemViewType(int position) {

        for(JobSeeker_AttacheClass jClass:jobSeeker_attacheClassList){
            newTest+=jClass.getFeeds_type();
        }
        Log.e("ADAPTER TESTVIEWTYPE: ",newTest);

        if(jobSeeker_attacheClassList.get(position).getFeeds_type().equals(ADS)){
            Log.e("ITEMVIEW: ",jobSeeker_attacheClassList.get(position).getFeeds_type());
            return Feeds_Ads;
        }
        else if(jobSeeker_attacheClassList.get(position).getFeeds_type().equals(JOBS)){
            Log.e("ITEMVIEW: ",jobSeeker_attacheClassList.get(position).getFeeds_type());
            return Feeds_Jobs;
        }
        else if(jobSeeker_attacheClassList.get(position).getFeeds_type().equals(VIDS)){
            Log.e("ITEMVIEW: ",jobSeeker_attacheClassList.get(position).getFeeds_type());
            return Feeds_Vids;
        }
        return 0;
    }

    public class ViewHolderAds extends RecyclerView.ViewHolder{

        TextView tv_feedsTypeAds,
                tv_adsTitle,
                tv_adsQulifications,
                tv_adsSkills,
                tv_adsYearsExpi,
                tv_adsDateCreated;


        public ViewHolderAds(View itemView) {
            super(itemView);
            tv_feedsTypeAds=(TextView) itemView.findViewById(R.id.tv_feedsType_ads);
            tv_adsTitle=(TextView) itemView.findViewById(R.id.ads_title);
            tv_adsQulifications=(TextView) itemView.findViewById(R.id.ads_qualifications);
            tv_adsSkills=(TextView) itemView.findViewById(R.id.ads_RequiredSkills);
            tv_adsYearsExpi=(TextView) itemView.findViewById(R.id.ads_YearsExperience);
            tv_adsDateCreated=(TextView) itemView.findViewById(R.id.tv_ads_dateCreated);

        }


    }


    public class ViewHolderJobs extends RecyclerView.ViewHolder{

        TextView tv_feedsTypeJobs,
                tv_jobsRequirements,
                tv_jobsQualifications,
                tv_jobsReqdSkills,
                tv_jobsYearsExpi,
                tv_jobsDateCreated;

        public ViewHolderJobs(View itemView) {
            super(itemView);
                    tv_feedsTypeJobs =(TextView) itemView.findViewById(R.id.tv_feedsType_jobs);
                    tv_jobsRequirements=(TextView) itemView.findViewById(R.id.jobs_requirements);
                    tv_jobsQualifications=(TextView) itemView.findViewById(R.id.jobs_qualifications);
                    tv_jobsReqdSkills=(TextView) itemView.findViewById(R.id.jobs_RequiredSkills);
                    tv_jobsYearsExpi=(TextView) itemView.findViewById(R.id.jobs_YearsExperience);
                    tv_jobsDateCreated=(TextView) itemView.findViewById(R.id.tv_jobs_dateCreated);

        }

        public TextView getTv_feedsTypeJobs() {
            return tv_feedsTypeJobs;
        }

        public void setTv_feedsTypeJobs(TextView tv_feedsTypeJobs) {
            this.tv_feedsTypeJobs = tv_feedsTypeJobs;
        }

        public TextView getTv_jobsRequirements() {
            return tv_jobsRequirements;
        }

        public void setTv_jobsRequirements(TextView tv_jobsRequirements) {
            this.tv_jobsRequirements = tv_jobsRequirements;
        }

        public TextView getTv_jobsQualifications() {
            return tv_jobsQualifications;
        }

        public void setTv_jobsQualifications(TextView tv_jobsQualifications) {
            this.tv_jobsQualifications = tv_jobsQualifications;
        }

        public TextView getTv_jobsReqdSkills() {
            return tv_jobsReqdSkills;
        }

        public void setTv_jobsReqdSkills(TextView tv_jobsReqdSkills) {
            this.tv_jobsReqdSkills = tv_jobsReqdSkills;
        }

        public TextView getTv_jobsYearsExpi() {
            return tv_jobsYearsExpi;
        }

        public void setTv_jobsYearsExpi(TextView tv_jobsYearsExpi) {
            this.tv_jobsYearsExpi = tv_jobsYearsExpi;
        }

        public TextView getTv_jobsDateCreated() {
            return tv_jobsDateCreated;
        }

        public void setTv_jobsDateCreated(TextView tv_jobsDateCreated) {
            this.tv_jobsDateCreated = tv_jobsDateCreated;
        }
    }


    public class ViewHolderVids extends RecyclerView.ViewHolder{


        TextView tv_feedsTypeVids,
                tv_vidsTitle,
                tv_vidsDescription,
                tv_vidsTags,
                tv_vidsLinks,
                tv_vidsDateCreated;

        public ViewHolderVids(View itemView) {
            super(itemView);
                    tv_feedsTypeVids=(TextView) itemView.findViewById(R.id.tv_feedsType_vids);
                    tv_vidsTitle=(TextView) itemView.findViewById(R.id.vids_title);
                    tv_vidsDescription=(TextView) itemView.findViewById(R.id.vids_description);
                    tv_vidsTags=(TextView) itemView.findViewById(R.id.vids_tags);
                    tv_vidsLinks=(TextView) itemView.findViewById(R.id.vids_links);
                    tv_vidsDateCreated=(TextView) itemView.findViewById(R.id.tv_vids_dateCreated);
        }

    }
}







































//---ON BIND VIEW-------------------------------

/* public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView adsTitle,adsQualifications,adsSkills;
        Button btn_refer;
        RelativeLayout relativeLayoutBackground;
        RoundedImageView roundedImageView;


        public MyViewHolder(View view) {
            super(view);
            adsTitle=(TextView)view.findViewById(R.id.ads_title);
            //adsQualifications=(TextView)view.findViewById(R.id.ads_qualifications_message);
            //adsSkills=(TextView)view.findViewById(R.id.ads_skills);
            btn_refer=(Button)view.findViewById(R.id.refer_btn);
            relativeLayoutBackground=(RelativeLayout)view.findViewById(R.id.relative_Layout_background);
            //roundedImageView=(RoundedImageView)view.findViewById(R.id.iv_company);
        }
    }

    public JobSeeker_AttacheAdapter(List<JobSeeker_AttacheClass> jobSeeker_attacheClassList,Context context) {
        this.jobSeeker_attacheClassList = jobSeeker_attacheClassList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext())
                                     .inflate(R.layout.jobseeker_attache_adslist,parent,false);

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
        holder.relativeLayoutBackground.setBackgroundResource(jobSeekerAttacheClass.getAdsBackground());*/



