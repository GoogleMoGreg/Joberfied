package com.chrs.iit.android.greg.joberfied;


import android.content.Intent;
import android.graphics.Color;
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
    private ViewPager viewPager;
    private Toolbar toolbar;
    private int[] images={
            R.drawable.ic_action_profile,
            R.drawable.ic_action_attache,
            R.drawable.ic_action_message,
            R.drawable.ic_action_bookmark
    };

    ViewPageAdapterJobSeeker viewPageAdapterJobSeeker;
    Drawer drawer;
    PrimaryDrawerItem itemViews,itemAdmires,itemFeeds;
    SecondaryDrawerItem itemEditProfile,itemRecomendJobs,itemExportCV,itemLogout;
    public static SearchView searchView;
    private DBSqliteHelper dbSqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobseeker_main);
        dbSqliteHelper=new DBSqliteHelper(this);
        tabLayout=(TabLayout)findViewById(R.id.sliding_Layout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        searchView=(SearchView)findViewById(R.id.searchView);
        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(viewPager);
        setupTabTitle();
        viewPager.setAdapter(viewPageAdapterJobSeeker);
        setupTabIcons();



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
        itemLogout=(SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(7).withName("Logout").withTextColor(Color.BLACK);
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

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tabLayout.getTabAt(0).isSelected()){
                    Log.e("MESSAGE: ","SELECTED TAB1");
                   // restartJobSeekerAtache();
                    Log.e("MESSAGE: ","RESTARTED TAB 2");
                }
                if(tabLayout.getTabAt(1).isSelected()){
                    Log.e("MESSAGE: ","SELECTED TAB2");

                }
                if(tabLayout.getTabAt(2).isSelected()){
                    Log.e("MESSAGE: ","SELECTED TAB3");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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
        viewPageAdapterJobSeeker =new ViewPageAdapterJobSeeker(getSupportFragmentManager());
        viewPageAdapterJobSeeker.addFragments(new JobSeekerProfile());
        viewPageAdapterJobSeeker.addFragments(new JobSeekerAttache());
        viewPageAdapterJobSeeker.addFragments(new JobSeekerMessage());
        viewPageAdapterJobSeeker.addFragments(new JobSeekerBookmark());
    }

    public void showLogut(){
        Intent showMainPage=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(showMainPage);
        this.finish();
    }




}
