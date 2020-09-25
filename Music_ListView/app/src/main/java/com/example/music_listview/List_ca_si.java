package com.example.music_listview;

import android.content.Context;

import java.util.List;

public class List_ca_si {
    private String name;
    private String chitiet;
    private int image;
    public List_ca_si(String name, String chitiet, int image) {
        this.name = name;
        this.chitiet = chitiet;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
