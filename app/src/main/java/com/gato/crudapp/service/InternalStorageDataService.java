package com.gato.crudapp.service;

import android.content.Context;
import android.util.Log;

import com.gato.crudapp.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.provider.Contacts.SettingsColumns.KEY;

/**
 * Created by gato on 09-07-17.
 */

public class InternalStorageDataService implements DataService {

    private String TAG = this.getClass().toString();

    private List<Person> personList = new ArrayList<Person>();

    private long lastId = 0l;

    @Override
    public Person save(Person person) {

        long lastId = getLastId();
        person.setId(lastId+1);

        // Retrieve the list from internal storage
        List<Person> persons = getPersonList();
        persons.add(person);

        return person;
    }

    @Override
    public Person edit(Person person) {
        Person oldPerson = getById(person.getId());
        delete(oldPerson.getId());
        return save(person);
    }

    @Override
    public void delete(long id) {
        Person person = getById(id);
        List<Person> personList = getPersonList();
        personList.remove(person);
    }

    @Override
    public Person getById(long id) {
        List<Person> persons = getPersonList();
        Iterator<Person> i = persons.iterator();

        Person foundPerson = null;
        while(i.hasNext() && foundPerson==null){
            Person iperson = i.next();
            long iid = iperson.getId();
            if(iid == id){
                foundPerson = iperson;
            }
        }

        return foundPerson;
    }

    @Override
    public List<Person> getPersonList() {
        return this.personList;
    }

    private long getLastId() {
        List<Person> personList = getPersonList();

        for(int i = 0; i < personList.size();i++){
            Person person = personList.get(i);
            long id = person.getId();
            if(id>lastId){
                lastId = id;
            }
        }

        return lastId;
    }
}