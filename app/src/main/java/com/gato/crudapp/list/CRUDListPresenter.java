package com.gato.crudapp.list;

import com.gato.crudapp.model.Person;
import com.gato.crudapp.service.DataService;
import com.gato.crudapp.service.SimpleDataService;

import java.util.List;

/**
 * Created by gato on 09-07-17.
 */

public class CRUDListPresenter implements ICRUDListPresenter {

    private DataService dataService;
    private List<Person> personList;
    private ICRUDListView view;

    public CRUDListPresenter(ICRUDListView cRUDListView){
        this.view = cRUDListView;

        this.dataService = new SimpleDataService();
        loadModel();
    }

    private void loadModel(){
        personList = dataService.getPersonList();
    }

    @Override
    public List<Person>  getModel(){
        return personList;
    }

    @Override
    public void save(Person person) {

    }

    @Override
    public void edit(Person person) {

    }

    @Override
    public void delete(long id) {
        dataService.delete(id);
        loadModel();
        getModel();
    }

    @Override
    public int getPersonsCount() {
        return 0;
    }
}
