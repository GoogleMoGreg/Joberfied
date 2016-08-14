package com.chrs.iit.android.greg.joberfied;


import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.SearchView;
import android.support.v4.app.FragmentTransaction;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class JobSeekerMain extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager_jobseeker;
    private Toolbar toolbar;
    private int[] images={
            R.drawable.ic_action_attache_red,
            R.drawable.ic_action_message_red,
            R.drawable.ic_action_bookmark__red,
            R.drawable.ic_action_profile_red
    };

    ViewPageAdapterJobSeeker viewPageAdapterJobSeeker;
    Drawer drawer_jobseeker;
    PrimaryDrawerItem itemViews_jobseeker,itemAdmires_jobseeker,itemFeeds_jobseeker;
    SecondaryDrawerItem itemEditProfile_jobseeker,itemRecomendJobs_jobseeker,itemExportCV_jobseeker,itemLogout_jobseeker;
    DBSqliteHelper dbSqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobseeker_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        dbSqliteHelper=new DBSqliteHelper(this);
        tabLayout=(TabLayout)findViewById(R.id.sliding_Layout);
        viewPager_jobseeker=(ViewPager)findViewById(R.id.viewPager);



        tabLayout.setupWithViewPager(viewPager_jobseeker);
        setupTabTitle();
        viewPager_jobseeker.setAdapter(viewPageAdapterJobSeeker);
        //viewPager.setOffscreenPageLimit(4);
        setupTabIcons();

        itemViews_jobseeker=new PrimaryDrawerItem().withIdentifier(1).withName("Views")
                .withTextColor(Color.BLACK)
                .withIcon(R.drawable.ic_view)
                .withBadge("1500")
                .withBadgeStyle(new BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_red_700));

        itemAdmires_jobseeker=new PrimaryDrawerItem().withIdentifier(2).withName("Admires by employers")
                .withTextColor(Color.BLACK)
                .withIcon(R.drawable.ic_heart)
                .withBadge("100")
                .withBadgeStyle(new BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_red_700));

        itemFeeds_jobseeker=new PrimaryDrawerItem().withIdentifier(3).withName("Recruitment Feedback")
                .withTextColor(Color.BLACK)
                .withIcon(R.drawable.ic_feedback)
                .withBadge("5")
                .withBadgeStyle(new BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_red_700));

        itemEditProfile_jobseeker= (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(4).withName("Edit Profile").withTextColor(Color.BLACK);
        itemRecomendJobs_jobseeker=(SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(5).withName("Recommended Jobs").withTextColor(Color.BLACK);
        itemExportCV_jobseeker=(SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(6).withName("Export CV").withTextColor(Color.BLACK);
        itemLogout_jobseeker=(SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(7).withName("Logout").withTextColor(Color.BLACK);
        drawer_jobseeker=new DrawerBuilder().withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        itemViews_jobseeker,
                        itemAdmires_jobseeker,
                        itemFeeds_jobseeker,
                        new DividerDrawerItem(),
                        itemEditProfile_jobseeker,
                        itemRecomendJobs_jobseeker,
                        itemExportCV_jobseeker,
                        itemLogout_jobseeker

                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if(drawerItem.getIdentifier()==1){
                            Log.e("MESSAGE: ","CLICKED 1");
                        }
                        else if (drawerItem.getIdentifier()==2) {
                            Log.e("MESSAGE: ","CLICKED 2");
                        }
                        else if (drawerItem.getIdentifier()==3) {
                            Log.e("MESSAGE: ","CLICKED 3");
                        }
                        else if (drawerItem.getIdentifier()==4) {
                            Log.e("MESSAGE: ","CLICKED 4");
                        }
                        else if (drawerItem.getIdentifier()==5) {
                            Log.e("MESSAGE: ","CLICKED 5");
                        }
                        else if (drawerItem.getIdentifier()==6) {
                            Log.e("MESSAGE: ","CLICKED 6");
                        }
                        else if (drawerItem.getIdentifier()==7) {
                            Log.e("MESSAGE: ","CLICKED 7");
                            dbSqliteHelper.logoutAccount();
                            Log.e("MESSAGE: ","DELETING DATABASE");
                            showLogut();
                        }

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
        viewPageAdapterJobSeeker =new ViewPageAdapterJobSeeker(getSupportFragmentManager());
        Log.e("MESSAGE: ","CALLING ATTACHE MAIN");
        viewPageAdapterJobSeeker.addFragments(new JobSeekerAttache());
        viewPageAdapterJobSeeker.addFragments(new JobSeekerMessage());
        viewPageAdapterJobSeeker.addFragments(new JobSeekerBookmark());
        viewPageAdapterJobSeeker.addFragments(new JobSeekerProfile());

    }

    public void showLogut(){
        Intent showMainPage=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(showMainPage);
        this.finish();
    }




}
