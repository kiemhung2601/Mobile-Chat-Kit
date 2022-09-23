package com.example.mobilechatkit.fragments;

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

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.databinding.FragmentChatBlankBinding;

public class ChatBlankFragment extends Fragment {

    FragmentChatBlankBinding biding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String name = getArguments().getString("nameGroup");
        String amount = getArguments().getString("amountPeople");

        biding.fragmentChatBlankAppbar.txtNameGroup.setText(name);
        biding.fragmentChatBlankAppbar.txtAmountMembers.setText(amount + " Members, 1 Online");
        NavController navController = Navigation.findNavController(view);
        biding.fragmentChatBlankAppbar.imbBack.setOnClickListener(new View.OnClickListener() {
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
        biding = FragmentChatBlankBinding.inflate(inflater, container, false);
        return biding.getRoot();
    }
}