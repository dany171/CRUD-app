package com.gato.crudapp.form;

import android.provider.ContactsContract;

import com.gato.crudapp.model.Person;
import com.gato.crudapp.service.DataService;
import com.gato.crudapp.service.SimpleDataService;

/**
 * Created by gato on 10-07-17.
 */

public class PersonFormPresenter implements IPersonFormPresenter {

    IPersonFormView view;
    DataService dataService;

    public PersonFormPresenter(IPersonFormView view){
        this.view = view;
        dataService = new SimpleDataService();
    }

    @Override
    public void save(Person person) {
        dataService.save(person);
        view.close();
    }

    @Override
    public void edit(Person person) {
        dataService.edit(person);
        view.close();
    }
}
