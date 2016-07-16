package com.chrs.iit.android.greg.joberfied;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.SearchView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class JobSeekerMain extends AppCompatActivity  {

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
    Drawer drawer;
    PrimaryDrawerItem itemViews,itemAdmires,itemFeeds;
    SecondaryDrawerItem itemEditProfile,itemRecomendJobs,itemExportCV,itemLogout;

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


        itemViews=new PrimaryDrawerItem().withIdentifier(1).withName("Views")
                                                           .withTextColor(Color.BLACK)
                                                           .withIcon(R.drawable.ic_view)
                                                           .withBadge("1500")
                                                           .withBadgeStyle(new BadgeStyle()
                                                                .withTextColor(Color.WHITE)
                                                                .withColorRes(R.color.md_red_700));

        itemAdmires=new PrimaryDrawerItem().withIdentifier(2).withName("Admires by employers")
                .withTextColor(Color.BLACK)
                .withIcon(R.drawable.ic_heart)
                .withBadge("100")
                .withBadgeStyle(new BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_red_700));

        itemFeeds=new PrimaryDrawerItem().withIdentifier(3).withName("Recruitment Feedback")
                .withTextColor(Color.BLACK)
                .withIcon(R.drawable.ic_feedback)
                .withBadge("5")
                .withBadgeStyle(new BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_red_700));

        itemEditProfile= (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(4).withName("Edit Profile").withTextColor(Color.BLACK);
        itemRecomendJobs=(SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(5).withName("Recommended Jobs").withTextColor(Color.BLACK);
        itemExportCV=(SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(6).withName("Export CV").withTextColor(Color.BLACK);
        itemLogout=(SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(6).withName("Logout").withTextColor(Color.BLACK);
        drawer=new DrawerBuilder().withActivity(this)
                                  .withToolbar(toolbar)
                                  .addDrawerItems(
                                        itemViews,
                                          itemAdmires,
                                          itemFeeds,
                                          new DividerDrawerItem(),
                                          itemEditProfile,
                                          itemRecomendJobs,
                                          itemExportCV,
                                          itemLogout

                                  ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }

                })
                .withDrawerGravity(Gravity.END)
                .build();


    }

    private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(images[0]);
        tabLayout.getTabAt(1).setIcon(images[1]);
        tabLayout.getTabAt(2).setIcon(images[2]);
        tabLayout.getTabAt(3).setIcon(images[3]);
    }

    private void setupTabTitle(){
        viewPageAdapterEmployer=new ViewPageAdapterEmployer(getSupportFragmentManager());
        viewPageAdapterEmployer.addFragments(new JobSeekerProfile());
        viewPageAdapterEmployer.addFragments(new JobSeekerAttache());
        viewPageAdapterEmployer.addFragments(new JobSeekerMessage());
        viewPageAdapterEmployer.addFragments(new JobSeekerBookmark());
        viewPager.setAdapter(viewPageAdapterEmployer);
    }


}
