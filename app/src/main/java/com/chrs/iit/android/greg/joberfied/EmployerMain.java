package com.chrs.iit.android.greg.joberfied;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;


public class EmployerMain extends AppCompatActivity  {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private int[] images={
            R.drawable.ic_action_profile,
            R.drawable.ic_action_attache,
            R.drawable.ic_action_message,
            R.drawable.ic_action_bookmark
    };

    ViewPageAdapterEmployer viewPageAdapterEmployer;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_main);
        tabLayout=(TabLayout)findViewById(R.id.sliding_Layout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        searchView=(SearchView)findViewById(R.id.searchView);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout.setupWithViewPager(viewPager);
        setupTabTitle();
        setupTabIcons();

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Message: ","sv is clicked!");
            }
        });

    }

    private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(images[0]);
        tabLayout.getTabAt(1).setIcon(images[1]);
        tabLayout.getTabAt(2).setIcon(images[2]);
        tabLayout.getTabAt(3).setIcon(images[3]);
    }

    private void setupTabTitle(){
        viewPageAdapterEmployer=new ViewPageAdapterEmployer(getSupportFragmentManager());
        viewPageAdapterEmployer.addFragments(new EmployerProfile());
        viewPageAdapterEmployer.addFragments(new EmployerAttache());
        viewPageAdapterEmployer.addFragments(new EmployerMessage());
        viewPageAdapterEmployer.addFragments(new EmployerBookmark());
        viewPager.setAdapter(viewPageAdapterEmployer);
    }


}
