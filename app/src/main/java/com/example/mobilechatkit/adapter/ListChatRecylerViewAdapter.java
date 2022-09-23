package com.example.mobilechatkit.adapter;

import android.app.Activity;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.model.Chat;

import java.util.List;

public class ListChatRecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity activity;
    private List<Chat> lstChat;

    public ListChatRecylerViewAdapter(Activity activity, List<Chat> lstChat) {
        this.activity = activity;
        this.lstChat = lstChat;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View itemViewHost = LayoutInflater.from(parent.getContext()).inflate(R.layout.host_layout, parent, false);
                return new ListChatRecylerViewAdapter.HostViewHolder(itemViewHost);
            case 2:
                View itemViewGuest = LayoutInflater.from(parent.getContext()).inflate(R.layout.guest_layout, parent, false);
                return new ListChatRecylerViewAdapter.GuestViewHolder(itemViewGuest);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Chat chat = lstChat.get(position);
        if(chat == null){
            return;
        }

        switch (holder.getItemViewType()) {
            case 0:
                ListChatRecylerViewAdapter.HostViewHolder viewHolderHost = (ListChatRecylerViewAdapter.HostViewHolder)holder;
                viewHolderHost.txtTime.setText(chat.getTime());

                LinearLayoutManager layoutManager = new LinearLayoutManager(activity.getApplicationContext());
                viewHolderHost.rcvMessage.setLayoutManager(layoutManager);

                MessageRecylerViewAdapter messageRecylerViewAdapter = new MessageRecylerViewAdapter(lstChat, activity, position);

                viewHolderHost.rcvMessage.setAdapter(messageRecylerViewAdapter);
                break;

            case 2:
                ListChatRecylerViewAdapter.GuestViewHolder viewHolderGuest = (ListChatRecylerViewAdapter.GuestViewHolder)holder;
                viewHolderGuest.txtTime.setText(chat.getTime());

                LinearLayoutManager layoutManager2 = new LinearLayoutManager(activity.getApplicationContext());
                viewHolderGuest.rcvMessage.setLayoutManager(layoutManager2);

                MessageRecylerViewAdapter messageRecylerViewAdapter2 = new MessageRecylerViewAdapter(lstChat, activity, position);

                viewHolderGuest.rcvMessage.setAdapter(messageRecylerViewAdapter2);

                break;
        }
    }

    @Override
    public int getItemCount() {
        return lstChat.size();
    }

    @Override
    public int getItemViewType(int position){
        if(lstChat.get(position).getType()){
            return 0;
        } else {
            return 2;
        }
    }

    class HostViewHolder extends RecyclerView.ViewHolder{
        RecyclerView rcvMessage;
        TextView txtTime;

        public HostViewHolder(@NonNull View itemView) {
            super(itemView);

            rcvMessage = itemView.findViewById(R.id.rcv_message_host);
            txtTime = itemView.findViewById(R.id.txt_time_host);
        }
    }

    class GuestViewHolder extends RecyclerView.ViewHolder{
        RecyclerView rcvMessage;
        TextView txtTime;

        public GuestViewHolder(@NonNull View itemView) {
            super(itemView);

            rcvMessage = itemView.findViewById(R.id.rcv_message_guest);
            txtTime = itemView.findViewById(R.id.txt_time_guest);
        }
    }
}
