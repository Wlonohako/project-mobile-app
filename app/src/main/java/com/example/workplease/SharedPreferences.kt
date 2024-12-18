package com.example.workplease

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


const val listName = "femboy"

data class Person(
    val name: String,
    val surname: String,
    val age: Int,
    val height: Int,
    val weight: Int
)

fun saveData(
    context: Context,
    name: String,
    surname: String,
    age: Int,
    height: Int,
    weight: Int
) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    val gson = Gson()

    // Load existing list or create a new one if it doesn't exist
    val existingListJson = sharedPreferences.getString("personList", null)
    val type = object : TypeToken<MutableList<Person>>() {}.type
    val personList: MutableList<Person> = if (existingListJson != null) {
        gson.fromJson(existingListJson, type)
    } else {
        mutableListOf()
    }

    // Add the new person to the list
    val newPerson = Person(name, surname, age, height, weight)
    personList.add(newPerson)

    // Save the updated list back to SharedPreferences
    val updatedListJson = gson.toJson(personList)
    editor.putString("personList", updatedListJson)
    editor.apply()
}

fun getPersonList(context: Context): List<Person> {
    // Get SharedPreferences
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
    val gson = Gson()

    // Get existing list or return empty if it doesn't exist
    val existingListJson = sharedPreferences.getString("personList", null)
    val type = object : TypeToken<MutableList<Person>>() {}.type
    return if (existingListJson != null) {
        gson.fromJson(existingListJson, type)
    } else {
        emptyList()
    }
}



