package com.example.mobilechatkit.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.swipe.SwipeLayout;
import com.example.mobilechatkit.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imgAvatar;
    TextView txtName, txtMessage, txtTime;
    public LinearLayout layoutForeGround;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imgAvatar = itemView.findViewById(R.id.img_avatar);
        txtName = itemView.findViewById(R.id.txt_name);
        txtMessage = itemView.findViewById(R.id.txt_message);
        txtTime = itemView.findViewById(R.id.txt_time);

        layoutForeGround = itemView.findViewById(R.id.layout_fore_ground);

    }
}
