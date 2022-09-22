package com.example.mobilechatkit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.model.People;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class PeopleAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private List<People> lstPeople;

    public void setData(List<People> list){
        this.lstPeople = list;
        notifyDataSetChanged();
    };

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder headerViewHolder;
        if(convertView == null){
            headerViewHolder = new HeaderViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);

            headerViewHolder.tvHeader = convertView.findViewById(R.id.tv_header);
            convertView.setTag(headerViewHolder);
        } else {
            headerViewHolder = (HeaderViewHolder) convertView.getTag();
        }

        headerViewHolder.tvHeader.setText(lstPeople.get(position).getName().substring(0 ,1));
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return lstPeople.get(position).getName().subSequence(0 , 1).charAt(0);
    }

    @Override
    public int getCount() {
        if(lstPeople != null){
            return lstPeople.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return lstPeople.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PeopleViewHolder peopleViewHolder;
        if(view == null){
            peopleViewHolder = new PeopleViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_people, viewGroup, false);
            peopleViewHolder.tvName = view.findViewById(R.id.txt_name);
            peopleViewHolder.imgAvatar = view.findViewById(R.id.img_avatar);

            view.setTag(peopleViewHolder);
        } else {
            peopleViewHolder = (PeopleViewHolder) view.getTag();
        }

        peopleViewHolder.tvName.setText(lstPeople.get(i).getName());
        peopleViewHolder.imgAvatar.setImageResource(lstPeople.get(i).getResourceId());

        return view;
    }


    public class HeaderViewHolder {
        private TextView tvHeader;
    }

    public class PeopleViewHolder {
        private ImageView imgAvatar;
        private TextView tvName;
    }
}
