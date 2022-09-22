package com.example.mobilechatkit.model;

import java.util.List;

public class Chat {
    private List<MessagesChat> lstMessage;
    private String time;
    private Boolean type;

    public Chat(List<MessagesChat> lstMessage, String time, Boolean type) {
        this.lstMessage = lstMessage;
        this.time = time;
        this.type = type;
    }

    public List<MessagesChat> getLstMessage() {
        return lstMessage;
    }

    public void setLstMessage(List<MessagesChat> lstMessage) {
        this.lstMessage = lstMessage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}
