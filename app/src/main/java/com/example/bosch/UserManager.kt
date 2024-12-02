package com.example.bosch

import android.content.Context
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class User(val name: String, val age: Int)


class UserManager(context: Context) { 
  
    // Create the dataStore and give it a name same as shared preferences 
    val Context.dataStore by preferencesDataStore(name = "user_preferences")
       // context.createDataStore(name = "user_prefs")
  
    // Create some keys we will use them to store and retrieve the data 
    companion object { 
        val USER_AGE_KEY = intPreferencesKey("USER_AGE")
            //intPreferencesKey()<Int>("USER_AGE")
        val USER_NAME_KEY = stringPreferencesKey("USER_NAME")
            //stringPreferencesKey()<String>("USER_NAME")
    } 
  
    // Store user data 
    // refer to the data store and using edit  
    // we can store values using the keys 
    suspend fun storeUser(age: Int, name: String,context: Context) {
        context.dataStore.edit {
                preferences ->
            preferences[USER_NAME_KEY] = name
            preferences[USER_AGE_KEY] = age
        }
    } 
  
    // Create an age flow to retrieve age from the preferences 
    // flow comes from the kotlin coroutine 

    val useAgeFlow:Flow<Int> = context.dataStore.data.map {
        it[USER_AGE_KEY]?:0
    }

//
//    // Create a name flow to retrieve name from the preferences
//    val userNameFlow: Flow<String> = dataStore.data.map {
//        it[USER_NAME_KEY] ?: ""
//    }
     val userNameFlow:Flow<String> = context.dataStore.data.map {
         it[USER_NAME_KEY]?: ""
}


    fun getUserPreferences(context: Context): Flow<User> {
        return context.dataStore.data
            .map { preferences ->
                val name = preferences[USER_NAME_KEY] ?: "Unknown"
                val age = preferences[USER_AGE_KEY] ?: 0
                User(name, age)
            }
    }
}