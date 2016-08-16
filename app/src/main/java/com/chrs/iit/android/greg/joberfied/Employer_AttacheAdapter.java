package com.chrs.iit.android.greg.joberfied;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import me.grantland.widget.AutofitTextView;

/**
 * Created by greg on 8/15/16.
 */
public class Employer_AttacheAdapter extends RecyclerView.Adapter<Employer_AttacheAdapter.MyViewHolder> {

    List<Employer_AttacheClass>employer_attacheClassList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public AutofitTextView pinNum,skills;
        public CircleImageView employerImage;
        public ImageView employerStatus;

        public MyViewHolder(View itemView) {
            super(itemView);
            pinNum=(AutofitTextView)itemView.findViewById(R.id.tv_employerAppPinNum);
            skills=(AutofitTextView)itemView.findViewById(R.id.tv_employer_skills);
            employerImage=(CircleImageView)itemView.findViewById(R.id.iv_employerAppPin);
            employerStatus=(ImageView)itemView.findViewById(R.id.iv_isExploring);
        }
    }

    public Employer_AttacheAdapter(List<Employer_AttacheClass> employer_attacheClassList) {
        this.employer_attacheClassList = employer_attacheClassList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.employer_attache_list
        ,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            Employer_AttacheClass employer_attacheClass=employer_attacheClassList.get(position);
            holder.pinNum.setText(employer_attacheClass.getPinNum());
            holder.skills.setText(employer_attacheClass.getAppSkills());
            holder.employerImage.setImageResource(employer_attacheClass.getEmployerImage());
            holder.employerStatus.setImageResource(employer_attacheClass.getEmployerStatus());
    }

    @Override
    public int getItemCount() {
        return employer_attacheClassList.size();
    }
}
