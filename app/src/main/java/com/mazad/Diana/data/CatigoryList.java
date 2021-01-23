package com.mazad.Diana.data;

public class CatigoryList {
    int id ,num_adds;
    String title ;
    String icon ;

    public CatigoryList(int id, int num_adds, String title, String icon) {
        this.id = id;
        this.num_adds = num_adds;
        this.title = title;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_adds() {
        return num_adds;
    }

    public void setNum_adds(int num_adds) {
        this.num_adds = num_adds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
