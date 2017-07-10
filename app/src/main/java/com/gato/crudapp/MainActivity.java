package com.gato.crudapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gato.crudapp.list.CRUDFragmentListView;
import com.gato.crudapp.list.dummy.DummyContent;
import com.gato.crudapp.model.Person;

public class MainActivity extends AppCompatActivity implements CRUDFragmentListView.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(Person item) {

    }
}
