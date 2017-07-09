package com.gato.crudapp.service;

import com.gato.crudapp.model.Person;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by gato on 09-07-17.
 */

public interface DataService {
    public Person save(Person item);
    public Person edit(Person item);
    public void delete(long id);
    public Person getById(long id);
    public List<Person> getPersonList();
}
