package com.example.amir.CollapsingToolbar;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private boolean isProfilePicVisible=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppBarLayout appBarLayout=findViewById(R.id.appbar);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);


        final ImageView profileImage=findViewById(R.id.profile_image);

        final LinearLayout toolBarView=findViewById(R.id.toolbarView);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int maxScroll=appBarLayout.getTotalScrollRange();
                float percentage=(float) Math.abs(i)/(float) maxScroll;

                if(percentage>=.7f && isProfilePicVisible){
                    profileImage.setVisibility(View.GONE);
                    toolBarView.setVisibility(View.VISIBLE);
                    isProfilePicVisible=false;
                }else if(percentage<.1f &&!isProfilePicVisible){
                    profileImage.setVisibility(View.VISIBLE);
                    toolBarView.setVisibility(View.GONE);
                    isProfilePicVisible=true;
                }
            }
        });
    }
}
