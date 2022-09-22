package com.example.mobilechatkit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mobilechatkit.adapter.ListMessageAdapter;
import com.example.mobilechatkit.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MentionFragment extends Fragment {

    private List<Message> lstMessage = new ArrayList<>();
    private ListView lstView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lstView = view.findViewById(R.id.lst_item_mention);

        lstMessage = getListMessage();

        ListMessageAdapter listMessageAdapter = new ListMessageAdapter(getActivity(), lstMessage);
        lstView.setAdapter(listMessageAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mention, container, false);
    }

    private List<Message> getListMessage(){
        List<Message> lstMessage = new ArrayList<>();
        lstMessage.add(new Message(R.drawable.avatar_1, "Photographers", "@andrewJ: do you like this imgur picture?", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_2, "Baker Hayfield", "@andrewJ: do you like this imgur picture? Another aspect is that the sun", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_3, "Regina Jones", "@andrewJ: Another aspect is that the sun? do you like this imgur picture?", "3:00 PM"));

        return lstMessage;
    }
}