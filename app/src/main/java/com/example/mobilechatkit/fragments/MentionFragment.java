package com.example.mobilechatkit.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.adapter.ListMessageListViewAdapter;
import com.example.mobilechatkit.databinding.FragmentMentionBinding;
import com.example.mobilechatkit.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MentionFragment extends Fragment {

    private List<Message> lstMessage = new ArrayList<>();

    FragmentMentionBinding biding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lstMessage = getListMessage();

        ListMessageListViewAdapter listMessageListViewAdapter = new ListMessageListViewAdapter(getActivity(), lstMessage);
        biding.fragmentMentionLvItemMention.setAdapter(listMessageListViewAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        biding = FragmentMentionBinding.inflate(inflater, container, false);
        return biding.getRoot();
    }

    private List<Message> getListMessage(){
        List<Message> lstMessage = new ArrayList<>();
        lstMessage.add(new Message(R.drawable.avatar_1, "Photographers", "@andrewJ: do you like this imgur picture?", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_2, "Baker Hayfield", "@andrewJ: do you like this imgur picture? Another aspect is that the sun", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_3, "Regina Jones", "@andrewJ: Another aspect is that the sun? do you like this imgur picture?", "3:00 PM"));

        return lstMessage;
    }
}