package com.gato.crudapp.list;

import com.gato.crudapp.model.Person;

import java.util.List;

/**
 * Created by gato on 14-07-17.
 */

public interface ListFragmentMVP {
    interface View{
        void goToShowPersonDetails(Person person);
        void goToEditPersonDetails(Person person);
    }

    interface Presenter{
        void editButtonClicked(Person person);
        void deleteButtonClicked(Person person);
        void showButtonClicked(Person person);
        void setView(ListFragmentMVP.View view);
    }

    interface Model{
        void savePerson(Person person);
        void editPerson(Person person);
        void deletePerson(Person person);
        List<Person> getList();
    }
}
