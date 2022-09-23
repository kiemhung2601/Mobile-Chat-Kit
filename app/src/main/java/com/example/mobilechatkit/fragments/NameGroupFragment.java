package com.example.mobilechatkit.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.adapter.ListAddedGroupRecyclerViewAdapter;
import com.example.mobilechatkit.databinding.FragmentNameGroupBinding;
import com.example.mobilechatkit.model.People;

import java.util.ArrayList;
import java.util.List;

public class NameGroupFragment extends Fragment {

    private List<People> lstPeople = new ArrayList<>();
    ListAddedGroupRecyclerViewAdapter nameGroupAdapter;
    LinearLayoutManager layoutManager;

    FragmentNameGroupBinding biding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layoutManager = new LinearLayoutManager(getContext());
        biding.fragmentNameGroupRcvPeopleAdded.setLayoutManager(layoutManager);

        lstPeople = getListPeople();

        nameGroupAdapter = new ListAddedGroupRecyclerViewAdapter(lstPeople);

        biding.fragmentNameGroupRcvPeopleAdded.setAdapter(nameGroupAdapter);

        biding.fragmentNameGroupTxtAmountPeople.setText(lstPeople.size() + " Members");

        NavController navController = Navigation.findNavController(view);
        biding.fragmentNameGroupAppbar.imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavOptions navOptions = new NavOptions.Builder().setPopUpTo(R.id.groupFragment2, true).build();
                navController.navigate(R.id.action_nameGroupFragment_to_groupFragment2, null, navOptions);
            }
        });

        biding.fragmentNameGroupAppbar.imbDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("nameGroup", String.valueOf(biding.fragmentNameGroupEtNameGroup.getText()));
                bundle.putString("amountPeople", String.valueOf(lstPeople.size()));

                navController.navigate(R.id.action_nameGroupFragment_to_chatBlankFragment, bundle);
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
        biding = FragmentNameGroupBinding.inflate(inflater, container, false);
        return biding.getRoot();
    }
}