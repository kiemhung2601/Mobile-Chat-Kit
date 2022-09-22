package com.example.mobilechatkit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.model.People;

import java.util.List;

public class NameGroupAdapter extends RecyclerView.Adapter<NameGroupAdapter.NameAddedViewHolder> {

    private List<People> lstPeople;

    public NameGroupAdapter(List<People> lstPeople) {
        this.lstPeople = lstPeople;
    }

    @NonNull
    @Override
    public NameAddedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name_group, parent, false);

        return new NameAddedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NameAddedViewHolder holder, int position) {
        int index = position;
        final People people = lstPeople.get(position);

        if(people == null){
            return;
        }

        holder.txtName.setText(people.getName());
        holder.imgAvatar.setImageResource(people.getResourceId());
        holder.imbDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(index);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lstPeople.size();
    }

    public class NameAddedViewHolder extends RecyclerView.ViewHolder{
        ImageView imgAvatar;
        TextView txtName;
        ImageButton imbDelete;
        public NameAddedViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            txtName = itemView.findViewById(R.id.txt_name);
            imbDelete = itemView.findViewById(R.id.imb_delete_members);
        }
    }

    public void removeItem(int index){
        lstPeople.remove(index);
        notifyItemRemoved(index);
    }
}
