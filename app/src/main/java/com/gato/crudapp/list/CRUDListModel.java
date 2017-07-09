package com.gato.crudapp.list;

import com.gato.crudapp.model.Person;

import java.util.List;

/**
 * Created by gato on 09-07-17.
 */

public class CRUDListModel {
    List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void add(Person person){
        personList.add(person);
    }


}

