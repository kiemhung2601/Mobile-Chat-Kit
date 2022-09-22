package com.example.mobilechatkit.my_interface;

import com.example.mobilechatkit.model.Message;
import com.example.mobilechatkit.model.People;

public interface IClickItemListener {

    void onLongClickItemUser(Message mesage);
    void onClickItemUser(Message message);
}
