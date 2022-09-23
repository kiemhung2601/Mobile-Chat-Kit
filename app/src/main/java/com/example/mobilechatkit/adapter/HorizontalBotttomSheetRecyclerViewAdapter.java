package com.example.mobilechatkit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.model.Message;

import java.util.List;

public class HorizontalBotttomSheetRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalBotttomSheetRecyclerViewAdapter.HorizontalViewHolder> {

    Context context;
    List<Message> lstMessage;

    public HorizontalBotttomSheetRecyclerViewAdapter(Context context, List<Message> lstMessage) {
        this.context = context;
        this.lstMessage = lstMessage;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_item_bottom_sheet, parent, false);

        return new HorizontalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {

        holder.imgAvatar.setImageResource(lstMessage.get(position).getResourceId());
        holder.txtName.setText(lstMessage.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return lstMessage.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAvatar;
        TextView txtName;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            txtName = itemView.findViewById(R.id.txt_name);

        }
    }
}
