package com.example.bosch.contentprovider;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    long insert(Contact contact);

    @Query("SELECT * FROM contacts")
    List<Contact> getAllContacts();
    
    @Query("SELECT * FROM contacts WHERE id = :id")
    Contact getContactById(long id);
}
