package com.example.workplease

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(private val personList: List<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    // ViewHolder class for each item
    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.nameTV)
        val surname = itemView.findViewById<TextView>(R.id.surnameTV)
        val age = itemView.findViewById<TextView>(R.id.ageTV)
        val high = itemView.findViewById<TextView>(R.id.highTV)
        val weight = itemView.findViewById<TextView>(R.id.weightTV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        // Inflate the item layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_human, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        // Bind data to the views
        val person = personList[position]
        holder.name.setText("Imię: ${person.name}")
        holder.surname.setText("Nazwisko: ${person.surname}")
        holder.age.setText("Nazwisko: ${person.age}")
        holder.high.setText("Nazwisko: ${person.height}")
        holder.weight.setText("Nazwisko: ${person.weight}")
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}
