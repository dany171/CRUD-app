package com.gato.crudapp.list;

import com.gato.crudapp.model.Person;

import java.util.List;

/**
 * Created by gato on 09-07-17.
 */

public interface ICRUDListView {

    public void setPersonList(List<Person> personList);
    public void goEdit(Person person);
    public void goView(Person person);
}