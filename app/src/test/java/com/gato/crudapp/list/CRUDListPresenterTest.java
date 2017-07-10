package com.gato.crudapp.list;

import com.gato.crudapp.model.Person;
import com.gato.crudapp.service.DataService;
import com.gato.crudapp.service.InternalStorageDataService;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by gato on 09-07-17.
 */
public class CRUDListPresenterTest {

    CRUDListPresenter cRUDListPresenter;
    ICRUDListView cRUDListView;
    DataService dataService;


    String p1Name     = "Matt Daemon";
    String p1Address  = "Route 66";
    String p1Birthday = "22/12/2002";
    String p1Email    = "matt.daemon@gmail.com";
    long p1phonenumber = 156474584l;

    String p2Name     = "Jim Carrey";
    String p2Address  = "Av. Chapare";
    String p2Birthday = "12/02/2000";
    String p2Email    = "jim.carrey@gmail.com";
    long p2phonenumber = 59164569874l;


    @Before
    public void before(){
        dataService = new InternalStorageDataService();
        cRUDListPresenter = new CRUDListPresenter(cRUDListView);
    }

    @Test
    public void LoadModelAndSetItToView(){

        Person p1 = new Person(p1Name,p1Address,p1Birthday,p1Email,p1phonenumber);
        Person p2 = new Person(p2Name,p2Address,p2Birthday,p2Email,p2phonenumber);

        dataService.save(p1);
        dataService.save(p2);

        CRUDListModel listModel = cRUDListPresenter.getModel();
        List<Person> personList = listModel.getPersonList();
        assertEquals(personList.size(), 2);

    }
}