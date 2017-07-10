package com.gato.crudapp.list;

import android.app.ListFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.gato.crudapp.R;
import com.gato.crudapp.model.Person;

import java.util.List;

/**
 * Created by gato on 09-07-17.
 */

public class CRUDListView extends ListFragment implements ICRUDListView{

    private ICRUDListPresenter cRUDListPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cRUDListPresenter = new CRUDListPresenter(this);

        return inflater.inflate(R.layout.person_list_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        List<Person> personList = cRUDListPresenter.getModel().getPersonList();

        /*ArrayAdapter<Person> itemsAdapter =
                new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, personList);*/


    }

    @Override
    public void setPersonList(List<Person> personList) {

    }
}
