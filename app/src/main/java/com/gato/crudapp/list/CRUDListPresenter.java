package com.gato.crudapp.list;

import com.gato.crudapp.model.Person;
import com.gato.crudapp.service.DataService;
import com.gato.crudapp.service.InternalStorageDataService;

import java.util.List;

/**
 * Created by gato on 09-07-17.
 */

public class CRUDListPresenter implements ICRUDListPresenter {

    private DataService dataService;
    private CRUDListModel cRUDListModel;
    private ICRUDListView cRUDListView;

    public CRUDListPresenter(ICRUDListView cRUDListView, DataService dataService){
        this.cRUDListView = cRUDListView;

        this.dataService = dataService;
        loadModel();
    }

    private void loadModel(){
        cRUDListModel = new CRUDListModel();
        List<Person> personList = dataService.getPersonList();
        cRUDListModel.setPersonList(personList);
    }



    @Override
    public CRUDListModel getModel() {
        return cRUDListModel;
    }

    @Override
    public void save(Person person) {

    }

    @Override
    public void edit(Person person) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int getPersonsCount() {
        return 0;
    }
}
