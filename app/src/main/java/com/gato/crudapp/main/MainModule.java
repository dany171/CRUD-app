package com.gato.crudapp.main;

import com.gato.crudapp.main.MainActivityMVP;
import com.gato.crudapp.main.MainActivityPresenter;
import com.gato.crudapp.main.MainModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gato on 14-07-17.
 */
@Module
public class MainModule {

    @Provides
    public MainActivityMVP.Presenter provideMainActivityPresenter(MainActivityMVP.Model model){
        return new MainActivityPresenter(model);
    }

    @Provides
    public MainActivityMVP.Model provideMainModel(){
        return new MainModel();
    }


}
