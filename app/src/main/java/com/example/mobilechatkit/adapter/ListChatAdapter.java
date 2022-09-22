package com.example.mobilechatkit.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.model.Chat;

import java.util.List;

public class ListChatAdapter extends BaseAdapter {

    private Activity activity;
    private List<Chat> lstChat;

    public ListChatAdapter(Activity activity, List<Chat> lstChat) {
        this.activity = activity;
        this.lstChat = lstChat;
    }

    @Override
    public int getCount() {
        return lstChat.size();
    }

    @Override
    public Object getItem(int i) {
        return lstChat.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();

        final Chat chat = lstChat.get(i);

        if(chat.getType()){
            view = inflater.inflate(R.layout.host_layout, null);

            RecyclerView rcvHost = view.findViewById(R.id.rcv_message_host);
            TextView txtTime = view.findViewById(R.id.txt_time_host);

            LinearLayoutManager layoutManager = new LinearLayoutManager(activity.getApplicationContext());

            rcvHost.setLayoutManager(layoutManager);

            MessageHostAdapter messageHostAdapter = new MessageHostAdapter(lstChat.get(i).getLstMessage(), activity);

            rcvHost.setAdapter(messageHostAdapter);
            return view;
        } else {
            view = inflater.inflate(R.layout.guest_layout, null);

            RecyclerView rcvGuest = view.findViewById(R.id.rcv_message_guest);
            TextView txtTime = view.findViewById(R.id.txt_time_guest);

            LinearLayoutManager layoutManager = new LinearLayoutManager(activity.getApplicationContext());
            rcvGuest.setLayoutManager(layoutManager);

            MessageGuestAdapter messageGuestAdapter = new MessageGuestAdapter(lstChat.get(i).getLstMessage(), activity);

            rcvGuest.setAdapter(messageGuestAdapter);
            return view;
        }
    }
}
