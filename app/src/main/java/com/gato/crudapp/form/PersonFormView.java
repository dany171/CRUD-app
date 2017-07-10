package com.gato.crudapp.form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gato.crudapp.R;
import com.gato.crudapp.model.Person;

public class PersonFormView extends AppCompatActivity implements IPersonFormView{

    private final String PERSON = "person";
    private final String EDITABLE = "editable";
    private final String EDIT = "edit";

    private EditText nameView;
    private EditText addressView;
    private EditText birthdayView;
    private EditText emailView;
    private EditText phoneView;
    private Button saveButton;

    private IPersonFormPresenter presenter;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_form);

        presenter = new PersonFormPresenter(this);
        initializeViews();
        configureViews();
        setEvents();
    }

    @Override
    public void close() {
        this.finish();
    }

    private void initializeViews(){
        nameView = (EditText) this.findViewById(R.id.editTextName);
        addressView = (EditText) this.findViewById(R.id.editTextAddress);
        birthdayView = (EditText) this.findViewById(R.id.editTextBirthday);
        emailView = (EditText) this.findViewById(R.id.editTextEmail);
        phoneView = (EditText) this.findViewById(R.id.editTextPhone);
        saveButton = (Button) this.findViewById(R.id.save);
    }

    private void configureViews(){
        Intent intent = getIntent();
        Object personObj = intent.getExtras().get(PERSON);

        if(personObj!=null){
            Person person = (Person) personObj;
            this.person = person;
            nameView.setText(person.getName());
            addressView.setText(person.getAddress());
            birthdayView.setText(person.getBirthday());
            emailView.setText(person.getEmail());
            phoneView.setText(Long.toString(person.getPhoneNumber()));
        }

        Object editableObj = intent.getExtras().get(EDITABLE);
        if(editableObj !=null){
            boolean editable = (boolean)editableObj;
            nameView.setEnabled(editable);
            addressView.setEnabled(editable);
            birthdayView.setEnabled(editable);
            emailView.setEnabled(editable);
            phoneView.setEnabled(editable);
            saveButton.setText(EDIT);

            int saveVisibility = editable? View.VISIBLE : View.INVISIBLE;
            saveButton.setVisibility(saveVisibility);
        }


    }

    private void setEvents(){
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameView.getText().toString();
                String address = addressView.getText().toString();
                String birthday = birthdayView.getText().toString();
                String email = emailView.getText().toString();
                String phone = phoneView.getText().toString();

                if(PersonFormView.this.person==null){
                    Person newPerson = new Person(name, address, birthday, email,
                            Long.parseLong(phone));

                    presenter.save(newPerson);

                }else{
                    PersonFormView.this.person.setName(name);
                    PersonFormView.this.person.setAddress(address);
                    PersonFormView.this.person.setBirthday(birthday);
                    PersonFormView.this.person.setEmail(email);
                    PersonFormView.this.person.setPhoneNumber(Long.parseLong(phone));

                    presenter.edit(PersonFormView.this.person);
                }
            }
        });
    }
}