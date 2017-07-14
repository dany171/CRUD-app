package com.gato.crudapp.main;

import com.gato.crudapp.model.Person;

/**
 * Created by gato on 14-07-17.
 */

public interface MainActivityMVP {

    interface View{
        void goToCreateView();
    }

    interface Presenter{
        void createPersonButtonClicked();
        void setView(MainActivityMVP.View view);
    }

    interface Model{
    }
}
