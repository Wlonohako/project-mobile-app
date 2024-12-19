package com.example.workplease

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(
    private val context: Context, // Add context as a parameter
    private val personList: MutableList<Person>
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.nameTV)
        val surname = itemView.findViewById<TextView>(R.id.surnameTV)
        val age = itemView.findViewById<TextView>(R.id.ageTV)
        val high = itemView.findViewById<TextView>(R.id.highTV)
        val weight = itemView.findViewById<TextView>(R.id.weightTV)
        val deleteButton = itemView.findViewById<Button>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_human, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = personList[position]
        holder.name.text = "Imię: ${person.name}"
        holder.surname.text = "Nazwisko: ${person.surname}"
        holder.age.text = "Wiek: ${person.age}"
        holder.high.text = "Wysokość: ${person.height}"
        holder.weight.text = "Waga: ${person.weight}"

        holder.deleteButton.setOnClickListener {
            val personToDelete = Person(
                name = person.name,
                surname = person.surname,
                age = person.age,
                height = person.height,
                weight = person.weight
            )
            // Use the context passed to the adapter
            deletePersonFromPreferences(context, personToDelete)
            personList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, personList.size)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}
