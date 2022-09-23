package com.example.mobilechatkit.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mobilechatkit.fragments.ChatsFragment;
import com.example.mobilechatkit.fragments.MentionFragment;

public class TabbarViewPagerAdapter extends FragmentStateAdapter {

    private View view;

    public TabbarViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, @NonNull View view) {
        super(fragmentActivity);
        this.view = view;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ChatsFragment(view);
            case 1:
                return new MentionFragment();
            default:
                return new ChatsFragment(view);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
