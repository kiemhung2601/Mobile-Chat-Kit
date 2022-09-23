package com.example.mobilechatkit.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.mobilechatkit.adapter.ListChatRecylerViewAdapter;
import com.example.mobilechatkit.databinding.FragmentMessageViewBinding;
import com.example.mobilechatkit.model.Chat;
import com.example.mobilechatkit.model.MessagesChat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageViewFragment extends Fragment {

    private List<Chat> lstChat = new ArrayList<>();

    FragmentMessageViewBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lstChat = getListChat();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        binding.fragmentMessageViewRcvChat.setLayoutManager(layoutManager);

        ListChatRecylerViewAdapter listChatRecylerViewAdapter = new ListChatRecylerViewAdapter(getActivity(), lstChat);
        binding.fragmentMessageViewRcvChat.setAdapter(listChatRecylerViewAdapter);

        binding.fragmentMessageViewChatMessage.imbSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.fragmentMessageViewRcvChat.smoothScrollToPosition(0);
            }
        });
    }

    private List<Chat> getListChat() {
        List<MessagesChat> lstMessage = new ArrayList<>();
        lstMessage.add(new MessagesChat("@andrewJ: do you like this imgur picture?"));
        lstMessage.add(new MessagesChat("Who was that photographer you shared with me recently?"));

        List<MessagesChat> lstMessage1 = new ArrayList<>();
        lstMessage1.add(new MessagesChat("That’s him!"));
        lstMessage1.add(new MessagesChat("What was his vision statement?"));

        List<MessagesChat> lstMessage2 = new ArrayList<>();
        lstMessage2.add(new MessagesChat("“Attractive people doing attractive things in attractive places” "));

        List<MessagesChat> lstMessage3 = new ArrayList<>();
        lstMessage3.add(new MessagesChat("@andrewJ: do you like this imgur picture?"));
        lstMessage3.add(new MessagesChat("Who was that photographer you shared with me recently?  zcczd ghyhv jjgg fvg yugu yutuy"));

        List<MessagesChat> lstMessage4 = new ArrayList<>();
        lstMessage4.add(new MessagesChat("Who was that photographer you shared with me recently? dsfsdfsd dsf sdaf sdf sdaf sd fsda fsdafsda fsd f sdafsadf sdfsadf sadfsdafsdaf sdafasdfsda fsdafsdafsda fsadfsdfsad"));

        List<MessagesChat> lstMessage5 = new ArrayList<>();
        lstMessage5.add(new MessagesChat("@andrewJ: do you like this imgur picture?"));
        lstMessage5.add(new MessagesChat("Who was that photographer you shared with me recently? sdfsdf sf sdf sdaf sadf sadfds á dà sadf sadf sa"));

        List<Chat> lstChat = new ArrayList<>();
        lstChat.add(new Chat(lstMessage,"3:00PM", true));
        lstChat.add(new Chat(lstMessage1,"2:50PM", false));
        lstChat.add(new Chat(lstMessage2,"2:40PM", true));
        lstChat.add(new Chat(lstMessage5,"2:35PM", false));
        lstChat.add(new Chat(lstMessage4,"2:30PM", true));
        lstChat.add(new Chat(lstMessage2,"2:25PM", false));
        lstChat.add(new Chat(lstMessage3,"2:20PM", true));

        return lstChat;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMessageViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}