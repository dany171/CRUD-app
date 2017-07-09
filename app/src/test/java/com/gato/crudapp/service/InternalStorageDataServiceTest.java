package com.gato.crudapp.service;

import com.gato.crudapp.model.Person;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gato on 09-07-17.
 */
public class InternalStorageDataServiceTest {

    private InternalStorageDataService dataService;
    private String name = "John Kennedy";
    private String address = "Fifth avenue #466";
    private String birthday = "21/01/2001";
    private String email = "john.kennedy@gmail.com";
    private long phoneNumber = 175966882l;

    private Person savedPerson;

    private String newName = "Juan Kanedo";
    private String newAddress = "Av. Pando #446";
    private String newBirthday = "21/01/2001";
    private String newEmail = "juan.kanedo@gmail.com";
    private long newPhoneNumber = 59175966882l;



    @Before
    public void before(){
        this.dataService = new InternalStorageDataService();
    }

    @Test
    public void save() throws Exception {
        Person person = new Person(name, address, birthday, email, phoneNumber);
        Person savedPerson = this.dataService.save(person);

        String savedName = savedPerson.getName();
        String savedAddress = savedPerson.getAddress();
        String savedBirthday = savedPerson.getBirthday();
        String savedEmail = savedPerson.getEmail();
        long savedPhoneNumber = savedPerson.getPhoneNumber();

        assertNotEquals(0, savedPerson.getId());
        assertNotNull(savedPerson);
        assertEquals(savedName, name);
        assertEquals(savedAddress, address);
        assertEquals(savedBirthday, birthday);
        assertEquals(savedEmail, email);
        assertEquals(savedPhoneNumber, phoneNumber);

    }

    @Test
    public void edit() throws Exception {
        Person person = new Person(name, address, birthday, email, phoneNumber);
        Person savedPerson = this.dataService.save(person);

        savedPerson.setName(newName);
        savedPerson.setAddress(newAddress);
        savedPerson.setBirthday(newBirthday);
        savedPerson.setEmail(newEmail);
        savedPerson.setPhoneNumber(newPhoneNumber);

        Person updatedPerson = this.dataService.edit(person);

        String updatedName = updatedPerson.getName();
        String updatedAddress = updatedPerson.getAddress();
        String updatedBirthday = updatedPerson.getBirthday();
        String updatedEmail = updatedPerson.getEmail();
        long updatedPhoneNumber = updatedPerson.getPhoneNumber();

        assertNotNull(updatedPerson);
        assertEquals(savedPerson.getId(), updatedPerson.getId());
        assertEquals(updatedName, newName);
        assertEquals(updatedAddress, newAddress);
        assertEquals(updatedBirthday, newBirthday);
        assertEquals(updatedEmail, newEmail);
        assertEquals(updatedPhoneNumber, newPhoneNumber);
    }

    @Test
    public void delete() throws Exception {
        Person person = new Person(name, address, birthday, email, phoneNumber);
        Person savedPerson = this.dataService.save(person);

        long id = person.getId();
        dataService.delete(id);
        Person retrievedPerson = dataService.getById(id);
        assertNull(retrievedPerson);
    }
}