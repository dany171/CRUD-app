package com.gato.crudapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gato.crudapp.form.PersonFormView;

public class MainActivity extends AppCompatActivity implements IMainView{

    private IMainPresenter presenter;
    private String SAVE = "save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);

        FloatingActionButton fPlusButton = (FloatingActionButton) findViewById(R.id.plus_person);
        fPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.create();
            }
        });
    }

    @Override
    public void goCreate() {
        Intent intent = new Intent(this, PersonFormView.class);
        intent.putExtra(SAVE, SAVE);
        startActivity(intent);
    }
}