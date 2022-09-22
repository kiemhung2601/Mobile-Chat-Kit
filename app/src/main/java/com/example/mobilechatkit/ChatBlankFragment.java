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
import android.widget.TextView;

public class ChatBlankFragment extends Fragment {

    private ImageButton imbBack;
    private TextView txtNameGroup, txtAmountPeople;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imbBack = view.findViewById(R.id.imb_back);
        txtNameGroup = view.findViewById(R.id.txt_name_group);
        txtAmountPeople = view.findViewById(R.id.txt_amount_members);

        String name = getArguments().getString("nameGroup");
        String amount = getArguments().getString("amountPeople");

        txtNameGroup.setText(name);
        txtAmountPeople.setText(amount + " Members, 1 Online");
        NavController navController = Navigation.findNavController(view);
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavOptions navOptions = new NavOptions.Builder().setPopUpTo(R.id.homeFragment, true).build();
                navController.navigate(R.id.action_chatBlankFragment_to_homeFragment, null, navOptions);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_blank, container, false);
    }
}