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
    private CRUDListModel cRUDListModel;
    private ICRUDListView cRUDListView;

    private String name = "John Kennedy";
    private String address = "Fifth avenue #466";
    private String birthday = "21/01/2001";
    private String email = "john.kennedy@gmail.com";
    private long phoneNumber = 175966882l;



    private String newName = "Juan Kanedo";
    private String newAddress = "Av. Pando #446";
    private String newBirthday = "21/01/2001";
    private String newEmail = "juan.kanedo@gmail.com";
    private long newPhoneNumber = 59175966882l;


    public CRUDListPresenter(ICRUDListView cRUDListView){
        this.cRUDListView = cRUDListView;

        this.dataService = new SimpleDataService();
        loadModel();
    }

    private void loadModel(){
        cRUDListModel = new CRUDListModel();
        List<Person> personList = dataService.getPersonList();
        /*Person p1 = new Person(name,address,birthday,email,phoneNumber);
        p1.setId(1l);
        Person p2 = new Person(newName,newAddress,newBirthday,newEmail,newPhoneNumber);
        p2.setId(2l);
        personList.add(p1);
        personList.add(p2);*/
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
        dataService.delete(id);
        loadModel();
        getModel();
    }

    @Override
    public int getPersonsCount() {
        return 0;
    }
}
