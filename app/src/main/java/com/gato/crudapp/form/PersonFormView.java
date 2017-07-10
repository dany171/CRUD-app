package com.gato.crudapp.form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gato.crudapp.R;
import com.gato.crudapp.model.Person;

public class PersonFormView extends AppCompatActivity implements IPersonFormView{

    EditText name;
    EditText address;
    EditText birthday;
    EditText email;
    EditText phone;
    Button save;
    IPersonFormPresenter presenter;
    Person person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new PersonFormPresenter(this);

        name = (EditText) this.findViewById(R.id.editTextName);
        address = (EditText) this.findViewById(R.id.editTextAddress);
        birthday = (EditText) this.findViewById(R.id.editTextBirthday);
        email = (EditText) this.findViewById(R.id.editTextEmail);
        phone = (EditText) this.findViewById(R.id.editTextPhone);
        save = (Button) this.findViewById(R.id.save);

        Intent intent = getIntent();
        Object message = intent.getExtras().get("edit");

        if(message!=null){
            Person person = (Person) message;
            this.person = person;
            save.setText("Edit");
            name.setText(person.getName());
            address.setText(person.getAddress());
            birthday.setText(person.getBirthday());
            email.setText(person.getEmail());
            phone.setText(Long.toString(person.getPhoneNumber()));

        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sname = name.getText().toString();
                String saddress = address.getText().toString();
                String sbirthday = birthday.getText().toString();
                String semail = email.getText().toString();
                String sphone = phone.getText().toString();

                if(PersonFormView.this.person==null){

                    Person newPerson = new Person(sname,saddress,sbirthday,semail,Long.parseLong(sphone));
                    presenter.save(newPerson);
                }else{
                    PersonFormView.this.person.setName(sname);
                    PersonFormView.this.person.setAddress(saddress);
                    PersonFormView.this.person.setBirthday(sbirthday);
                    PersonFormView.this.person.setEmail(semail);
                    PersonFormView.this.person.setPhoneNumber(Long.parseLong(sphone));

                    presenter.edit(PersonFormView.this.person);
                }


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void close() {
        this.finish();
    }
}
