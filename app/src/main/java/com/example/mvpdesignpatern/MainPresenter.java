package com.example.mvpdesignpatern;

import com.example.mvpdesignpatern.model.MainModel;

public class MainPresenter {
    private MainView view;

    MainPresenter(MainView view){
        this.view = view;
    }

    public int luas(int panjang, int lebar){
        return  panjang*lebar;
    }

    public void hitungLuas(int panjang, int lebar){
        int luas = luas(panjang, lebar);
        MainModel model = new MainModel(luas);
        view.showLuas(model);
    }
}
