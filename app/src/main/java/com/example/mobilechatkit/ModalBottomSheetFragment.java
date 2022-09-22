package com.example.mobilechatkit;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilechatkit.adapter.RecyclerViewHorizontalAdapter;
import com.example.mobilechatkit.adapter.SwipeAdapter;
import com.example.mobilechatkit.model.Message;


import java.util.ArrayList;
import java.util.List;

public class ModalBottomSheetFragment extends Fragment {

    private List<Message> lstMessage = new ArrayList<>();
    private RecyclerView recyclerView;
    RecyclerViewHorizontalAdapter recyclerViewHorizontalAdapter;
    LinearLayoutManager layoutManager;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_horizontal);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        lstMessage = getListMessage();

        recyclerViewHorizontalAdapter = new RecyclerViewHorizontalAdapter(getContext(), lstMessage);

        recyclerView.setAdapter(recyclerViewHorizontalAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.modal_bottom_sheet_layout, container, false);
    }

    private List<Message> getListMessage(){
        List<Message> lstMessage = new ArrayList<>();
        lstMessage.add(new Message(R.drawable.avatar_1, "Photographers", "@andrewJ: do you like this imgur picture?", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_2, "Baker Hayfield", "@andrewJ: do you like this imgur picture? Another aspect is that the sun", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_3, "Regina Jones", "@andrewJ: Another aspect is that the sun? do you like this imgur picture?", "3:00 PM"));

        lstMessage.add(new Message(R.drawable.avatar_1, "Photographers", "@andrewJ: do you like this imgur picture?", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_2, "Baker Hayfield", "@andrewJ: do you like this imgur picture? Another aspect is that the sun", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_3, "Regina Jones", "@andrewJ: Another aspect is that the sun? do you like this imgur picture?", "3:00 PM"));

        lstMessage.add(new Message(R.drawable.avatar_1, "Photographers", "@andrewJ: do you like this imgur picture?", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_2, "Baker Hayfield", "@andrewJ: do you like this imgur picture? Another aspect is that the sun", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_3, "Regina Jones", "@andrewJ: Another aspect is that the sun? do you like this imgur picture?", "3:00 PM"));


        return lstMessage;
    }
}
