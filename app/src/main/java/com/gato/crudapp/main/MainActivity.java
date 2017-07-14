package com.gato.crudapp.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gato.crudapp.R;
import com.gato.crudapp.form.PersonFormView;
import com.gato.crudapp.root.App;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityMVP.View{

    @Inject
    MainActivityMVP.Presenter presenter;

    private FloatingActionButton create;
    private String SAVE = "save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((App) getApplication()).getComponent().inject(this);

        setContentView(R.layout.activity_main);
        create = (FloatingActionButton) findViewById(R.id.plus_person);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public void goToCreateView() {
        Intent intent = new Intent(this, PersonFormView.class);
        intent.putExtra(SAVE, SAVE);
        startActivity(intent);
    }
}