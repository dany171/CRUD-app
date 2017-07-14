package com.gato.crudapp.root;

import com.gato.crudapp.main.MainActivity;
import com.gato.crudapp.main.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gato on 12-07-17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, MainModule.class})
public interface ApplicationComponent {

    void inject (MainActivity target);

}
