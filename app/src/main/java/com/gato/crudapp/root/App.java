package com.gato.crudapp.root;

import android.app.Application;

import com.gato.crudapp.DaggerApplicationComponent;
import com.gato.crudapp.main.MainModule;

/**
 * Created by gato on 12-07-17.
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate(){
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .mainModule(new MainModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
