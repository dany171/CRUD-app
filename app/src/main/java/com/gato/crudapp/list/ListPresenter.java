package com.gato.crudapp.list;

import com.gato.crudapp.model.Person;
import com.gato.crudapp.service.DataService;
import com.gato.crudapp.service.SimpleDataService;

import java.util.List;

/**
 * Created by gato on 09-07-17.
 */

public class ListPresenter implements IListPresenter {

    private DataService dataService;
    private List<Person> personList;
    private IListView view;

    public ListPresenter(IListView view){
        this.view = view;
        this.dataService = new SimpleDataService();
        loadModel();
    }

    @Override
    public void loadModel(){
        personList = dataService.getPersonList();
        view.setData(personList);
    }

    @Override
    public List<Person>  getModel(){
        return personList;
    }

    @Override
    public void view(Person person) {
        view.goView(person);
    }

    @Override
    public void edit(Person person) {
        view.goEdit(person);
    }

    @Override
    public void delete(long id) {
        dataService.delete(id);
        loadModel();
    }
}
