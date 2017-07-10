package com.gato.crudapp;

/**
 * Created by gato on 10-07-17.
 */

public class MainPresenter implements IMainPresenter {

    IMainView view;

    public MainPresenter(IMainView view){
        this.view = view;
    }

    @Override
    public void create() {
        view.goCreate();
    }
}
