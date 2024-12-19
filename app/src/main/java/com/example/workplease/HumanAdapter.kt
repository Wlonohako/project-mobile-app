package com.example.workplease

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(
    private val context: Context,
    private val personList: MutableList<Person>
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameTV)
        val surname: TextView = itemView.findViewById(R.id.surnameTV)
        val age: TextView = itemView.findViewById(R.id.ageTV)
        val height: TextView = itemView.findViewById(R.id.highTV)
        val weight: TextView = itemView.findViewById(R.id.weightTV)
        val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
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
        holder.height.text = "Wysokość: ${person.height}"
        holder.weight.text = "Waga: ${person.weight}"

        holder.deleteButton.setOnClickListener {
            deletePersonFromPreferences(context, person)
            personList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, personList.size - position)
        }
    }

    override fun getItemCount(): Int = personList.size

}
