package com.gato.crudapp.model;

import java.io.Serializable;

/**
 * Created by gato on 09-07-17.
 */

public class Person implements Serializable{

    protected long id;
    protected String name;
    protected String address;
    protected String birthday;
    protected String email;
    protected long phoneNumber;

    public Person(
            String name,
            String address,
            String birthday,
            String email,
            long phoneNumber
    ) {
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
