package com.example.music_listview;

public class List_bai_hat {

    private   String tenbaihat;
    private   int File;

    public List_bai_hat(String tenbaihat, int file) {
        this.tenbaihat = tenbaihat;
        File = file;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public int getFile() {
        return File;
    }

    public void setFile(int file) {
        File = file;
    }
}
