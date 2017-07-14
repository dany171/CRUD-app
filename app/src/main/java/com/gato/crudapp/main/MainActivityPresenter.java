package com.gato.crudapp.main;

import android.support.annotation.Nullable;

/**
 * Created by gato on 14-07-17.
 */

public class MainActivityPresenter implements MainActivityMVP.Presenter{

    @Nullable
    private MainActivityMVP.View view;
    private MainActivityMVP.Model model;

    public MainActivityPresenter(MainActivityMVP.Model model){
        this.model = model;
    }

    @Override
    public void createPersonButtonClicked() {
        if(view == null){
            System.out.println("App state error");
            return;
        }
        view.goToCreateView();
    }

    @Override
    public void setView(MainActivityMVP.View view) {
        this.view = view;
    }
}
