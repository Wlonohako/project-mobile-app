package com.example.workplease;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

const val listName = "AppPreferences";
const val keyName = "personList"

data class Person(
    val name: String,
    val surname: String,
    val age: Int,
    val height: Int,
    val weight: Int
);

fun saveData(
    context: Context,
    name: String,
    surname: String,
    age: Int,
    height: Int,
    weight: Int
) {
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(listName, Context.MODE_PRIVATE);
    val editor = sharedPreferences.edit();
    val gson = Gson();

    val existingListJson = sharedPreferences.getString(keyName, null);
    val type = object : TypeToken<MutableList<Person>>() {}.type;
    val personList: MutableList<Person> = if (existingListJson != null) {
        gson.fromJson(existingListJson, type);
    } else {
        mutableListOf();
    }

    val newPerson = Person(name, surname, age, height, weight);
    personList.add(newPerson);

    val updatedListJson = gson.toJson(personList);
    editor.putString(keyName, updatedListJson);
    editor.apply();
}

fun getPersonList(context: Context): List<Person> {
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(listName, Context.MODE_PRIVATE);
    val gson = Gson();

    val existingListJson = sharedPreferences.getString(keyName, null);
    val type = object : TypeToken<MutableList<Person>>() {}.type;
    return if (existingListJson != null) {
        gson.fromJson(existingListJson, type);
    } else {
        emptyList();
    }
}

fun deletePersonFromPreferences(context: Context, person: Person) {
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(listName, Context.MODE_PRIVATE);
    val editor = sharedPreferences.edit();
    val gson = Gson();

    val existingListJson = sharedPreferences.getString(keyName, null);
    val type = object : TypeToken<MutableList<Person>>() {}.type;
    val personList: MutableList<Person> = if (existingListJson != null) {
        gson.fromJson(existingListJson, type);
    } else {
        mutableListOf();
    }

    personList.remove(person);

    val updatedListJson = gson.toJson(personList);
    editor.putString(keyName, updatedListJson);
    editor.apply();
    Toast.makeText(context, "Usunięto osobę", Toast.LENGTH_SHORT).show()
}
