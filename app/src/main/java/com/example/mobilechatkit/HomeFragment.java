package com.example.mobilechatkit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.mobilechatkit.adapter.MyViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    private ImageButton imbAvatarAccount, imbCreateGroup;
    private ViewPager2 mViewPager2;
    private BottomNavigationView mBottomNavigationView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        mDrawerLayout = view.findViewById(R.id.drawer_layout);
        imbAvatarAccount = view.findViewById(R.id.imb_avt_account);
        imbCreateGroup = view. findViewById(R.id.imb_create_group);

        mViewPager2 = view.findViewById(R.id.view_pager_2);
        mBottomNavigationView = view.findViewById(R.id.bottomNavigationView);

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getActivity(), view);

        mViewPager2.setAdapter(myViewPagerAdapter);

        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.chats){
                    mViewPager2.setCurrentItem(0);
                } else if(id == R.id.mentions){
                    mViewPager2.setCurrentItem(1);
                }
                return true;
            }
        });

        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.chats).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.mentions).setChecked(true);
                        break;
                }
            }
        });

        imbAvatarAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        imbCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_homeFragment_to_groupFragment2);
            }
        });

        NavigationView navigationView = view.findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.new_direct_message) {

        } else if(id == R.id.new_group) {

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

//    @Override
//    public void onBackPressed(){
//        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
//            mDrawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
}