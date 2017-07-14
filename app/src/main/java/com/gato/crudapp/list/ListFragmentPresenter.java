package com.gato.crudapp.list;

import android.support.annotation.Nullable;

import com.gato.crudapp.model.Person;
import com.gato.crudapp.service.DataService;
import com.gato.crudapp.service.SimpleDataService;

import java.util.List;

/**
 * Created by gato on 09-07-17.
 */

public class ListFragmentPresenter implements ListFragmentMVP.Presenter {

    @Nullable
    private ListFragmentMVP.View view;
    private ListFragmentMVP.Model model;

    public ListFragmentPresenter(ListFragmentMVP.Model model){
        this.model = model;
    }

    @Override
    public void setView(ListFragmentMVP.View view) {
        this.view = view;
    }

    @Override
    public void showButtonClicked(Person person) {
        view.goToShowPersonDetails(person);
    }

    @Override
    public void editButtonClicked(Person person) {
        view.goToEditPersonDetails(person);
    }

    @Override
    public void deleteButtonClicked(Person person) {
        model.deletePerson(person);
    }
}
