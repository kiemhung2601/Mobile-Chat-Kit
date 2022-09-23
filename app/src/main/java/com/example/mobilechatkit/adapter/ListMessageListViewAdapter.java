package com.example.mobilechatkit.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.model.Message;

import java.util.List;

public class ListMessageListViewAdapter extends BaseAdapter {

    private Activity activity;
    private List<Message> lstMessage;

    public ListMessageListViewAdapter(Activity activity, List<Message> lstMessage) {
        this.activity = activity;
        this.lstMessage = lstMessage;
    }

    @Override
    public int getCount() {
        return lstMessage.size();
    }

    @Override
    public Object getItem(int i) {
        return lstMessage.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();

        view = inflater.inflate(R.layout.layout_item_mess_mention, null);

        TextView txtName = view.findViewById(R.id.txt_name);
        TextView txtMessage = view.findViewById(R.id.txt_message);
        TextView txtTime = view.findViewById(R.id.txt_time);
        ImageView imgAvatar = view.findViewById(R.id.img_avatar);

        txtName.setText(lstMessage.get(i).getName());
        txtMessage.setText(lstMessage.get(i).getMessge());
        txtTime.setText(lstMessage.get(i).getTime());
        imgAvatar.setImageResource(lstMessage.get(i).getResourceId());

        return view;
    }
}
