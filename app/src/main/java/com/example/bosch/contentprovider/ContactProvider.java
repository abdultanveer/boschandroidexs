package com.example.bosch.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

import androidx.room.Room;

import java.util.List;

public class ContactProvider extends ContentProvider {

    private AppDatabase db;

    @Override
    public boolean onCreate() {
        // Initialize the Room database
        db = Room.databaseBuilder(getContext(), AppDatabase.class, "contacts.db")
                .allowMainThreadQueries() // for simplicity, use background thread in production
                .build();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        List<Contact> contacts = db.contactDao().getAllContacts();

        MatrixCursor cursor = new MatrixCursor(new String[]{
                ContactContract.Contacts.COLUMN_ID,
                ContactContract.Contacts.COLUMN_NAME,
                ContactContract.Contacts.COLUMN_PHONE
        });

        for (Contact contact : contacts) {
            cursor.addRow(new Object[]{
                    contact.getId(),
                    contact.getName(),
                    contact.getPhone()
            });
        }

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/vnd.com.example.appa.contacts";
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String name = values.getAsString(ContactContract.Contacts.COLUMN_NAME);
        String phone = values.getAsString(ContactContract.Contacts.COLUMN_PHONE);

        Contact contact = new Contact(name, phone);
        long id = db.contactDao().insert(contact);

        return ContentUris.withAppendedId(ContactContract.CONTENT_URI, id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // You can implement delete functionality based on the URI and selection
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // Implement update functionality if needed
        return 0;
    }
}
