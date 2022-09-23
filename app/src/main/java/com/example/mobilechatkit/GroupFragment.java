package com.example.mobilechatkit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.mobilechatkit.adapter.PeopleAdapter;
import com.example.mobilechatkit.databinding.FragmentGroupBinding;
import com.example.mobilechatkit.model.People;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class GroupFragment extends Fragment {

    private PeopleAdapter peopleAdapter;

    FragmentGroupBinding biding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        peopleAdapter = new PeopleAdapter();

        peopleAdapter.setData(getListPeople());
        biding.lstPeople.setAdapter(peopleAdapter);

        NavController navController = Navigation.findNavController(view);

        biding.appbar.imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavOptions navOptions = new NavOptions.Builder().setPopUpTo(R.id.homeFragment, true).build();
                navController.navigate(R.id.action_groupFragment2_to_homeFragment, null, navOptions);
            }
        });

        biding.appbar.imbNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_groupFragment2_to_nameGroupFragment);
            }
        });

    }

    private List<People> getListPeople() {
        List<People> lstPeople = new ArrayList<>();
        lstPeople.add(new People(R.drawable.avatar_1, "Andrew Jackson"));
        lstPeople.add(new People(R.drawable.avatar_2, "Alision Gilchrist"));
        lstPeople.add(new People(R.drawable.avatar_3, "Baker Hayfield"));
        lstPeople.add(new People(R.drawable.avatar_2, "David villa"));
        lstPeople.add(new People(R.drawable.avatar_1, "Nash Brick"));
        lstPeople.add(new People(R.drawable.avatar_3, "Photographers"));
        return lstPeople;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        biding = FragmentGroupBinding.inflate(inflater, container, false);
        return biding.getRoot();
    }
}