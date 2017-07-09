package com.gato.crudapp.list;

import com.gato.crudapp.model.Person;

/**
 * Created by gato on 09-07-17.
 */

public interface ICRUDListPresenter {

    //public CRUDListView getView();
    public CRUDListModel getModel();

    public void save(Person person);
    public void edit(Person person);
    public void delete(long id);
    public int getPersonsCount();

}
