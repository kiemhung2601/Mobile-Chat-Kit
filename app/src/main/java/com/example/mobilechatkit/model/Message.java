package com.example.mobilechatkit.model;

public class Message {
    private int resourceId;
    private String name;
    private String messge;
    private String time;

    public Message(int resourceId, String name, String messge, String time) {
        this.resourceId = resourceId;
        this.name = name;
        this.messge = messge;
        this.time = time;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
