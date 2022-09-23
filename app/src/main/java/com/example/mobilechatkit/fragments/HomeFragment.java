package com.example.mobilechatkit.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.adapter.TabbarViewPagerAdapter;
import com.example.mobilechatkit.databinding.FragmentHomeBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    FragmentHomeBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        TabbarViewPagerAdapter myViewPagerAdapter = new TabbarViewPagerAdapter(getActivity(), view);

        binding.fragmentHomeViewPager2.setAdapter(myViewPagerAdapter);

        binding.fragmentHomeBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.chats){
                    binding.fragmentHomeViewPager2.setCurrentItem(0);
                } else if(id == R.id.mentions){
                    binding.fragmentHomeViewPager2.setCurrentItem(1);
                }
                return true;
            }
        });

        binding.fragmentHomeViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        binding.fragmentHomeBottomNavigationView.getMenu().findItem(R.id.chats).setChecked(true);
                        break;
                    case 1:
                        binding.fragmentHomeBottomNavigationView.getMenu().findItem(R.id.mentions).setChecked(true);
                        break;
                }
            }
        });

        binding.fragmentHomeAppbar.imbAvtAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.fragmentHomeDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        binding.fragmentHomeAppbar.imbCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_homeFragment_to_groupFragment2);
            }
        });

        NavigationView navigationView = view.findViewById(R.id.fragment_home_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.new_direct_message) {

        } else if(id == R.id.new_group) {

        }

        binding.fragmentHomeDrawerLayout.closeDrawer(GravityCompat.START);
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