package com.example.mobilechatkit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.adapter.HorizontalBotttomSheetRecyclerViewAdapter;
import com.example.mobilechatkit.databinding.FragmentModalBottomSheetLayoutBinding;
import com.example.mobilechatkit.model.Message;


import java.util.ArrayList;
import java.util.List;

public class ModalBottomSheetFragment extends Fragment {

    private List<Message> lstMessage = new ArrayList<>();
    HorizontalBotttomSheetRecyclerViewAdapter recyclerViewHorizontalAdapter;
    LinearLayoutManager layoutManager;

    FragmentModalBottomSheetLayoutBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fragmentBottomsheetRcvHorizontal.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        binding.fragmentBottomsheetRcvHorizontal.setLayoutManager(layoutManager);

        lstMessage = getListMessage();

        recyclerViewHorizontalAdapter = new HorizontalBotttomSheetRecyclerViewAdapter(getContext(), lstMessage);

        binding.fragmentBottomsheetRcvHorizontal.setAdapter(recyclerViewHorizontalAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentModalBottomSheetLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
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
