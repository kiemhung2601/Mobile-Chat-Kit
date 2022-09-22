package com.example.mobilechatkit.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.model.Message;
import com.example.mobilechatkit.my_interface.IClickItemListener;

import java.util.List;

public class SwipeAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<Message> lstMessage;
    private IClickItemListener iClickItemListener;

    public SwipeAdapter(List<Message> lstMessage, IClickItemListener listener) {
        this.lstMessage = lstMessage;
        this.iClickItemListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mess_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Message message = lstMessage.get(position);
        if(message == null){
            return;
        }

        holder.imgAvatar.setImageResource(lstMessage.get(position).getResourceId());
        holder.txtName.setText(lstMessage.get(position).getName());
        holder.txtMessage.setText(lstMessage.get(position).getMessge());
        holder.txtTime.setText(lstMessage.get(position).getTime());

        holder.layoutForeGround.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                iClickItemListener.onLongClickItemUser(message);
                return true;
            }
        });

        holder.layoutForeGround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemListener.onClickItemUser(message);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstMessage.size();
    }

    public void removeItem(int index){
        lstMessage.remove(index);
        notifyItemRemoved(index);
    }

    public void undoItem(Message message, int index){
        lstMessage.add(index, message);
        notifyItemInserted(index);
    }
}
