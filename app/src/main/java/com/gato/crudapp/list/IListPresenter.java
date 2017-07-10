package com.gato.crudapp.list;

import com.gato.crudapp.model.Person;

import java.util.List;

/**
 * Created by gato on 09-07-17.
 */

public interface IListPresenter {

    public List<Person> getModel();
    public void loadModel();
    public void edit(Person person);
    public void view(Person person);
    public void delete(long id);
}
