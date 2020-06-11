package com.example.tapfo;

import java.util.ArrayList;

public class StoreInfo {
    private ArrayList<String> storeName = new ArrayList<>();
    private ArrayList<Integer> storeLogo = new ArrayList<>();
    private int position;

    public StoreInfo(ArrayList<String> storeName, ArrayList<Integer> storeLogo, int position) {
        this.storeName = storeName;
        this.storeLogo = storeLogo;
        this.position = position;
    }

    public ArrayList<String> getStoreName() {
        return storeName;
    }

    public void setStoreName(ArrayList<String> storeName) {
        this.storeName = storeName;
    }

    public ArrayList<Integer> getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(ArrayList<Integer> storeLogo) {
        this.storeLogo = storeLogo;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
