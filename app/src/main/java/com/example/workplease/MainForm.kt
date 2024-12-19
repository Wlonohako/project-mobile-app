package com.example.workplease


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_form)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val screenTwoButton = findViewById<Button>(R.id.ScreenTwoButton)
        screenTwoButton.setOnClickListener {
            val intent = Intent(this, PersonList::class.java)
            startActivity(intent)
        }

        saveButton.setOnClickListener {
            val nameTextInput = findViewById<EditText>(R.id.nameInput).text.toString()
            val surnameTextInput = findViewById<EditText>(R.id.surnameInput).text.toString()
            val ageNumberInput = findViewById<EditText>(R.id.ageInput).text.toString()
            val highNumberInput = findViewById<EditText>(R.id.highInput).text.toString()
            val weightNumberInput = findViewById<EditText>(R.id.weightInput).text.toString()

            if (nameTextInput.isEmpty() || surnameTextInput.isEmpty() || ageNumberInput.isEmpty() || highNumberInput.isEmpty() || weightNumberInput.isEmpty()) {
                Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (ageNumberInput.toInt() < 0) {
                Toast.makeText(this, "Age must be greater than 0", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (highNumberInput.toInt() !in 50..250) {
                Toast.makeText(this, "High must be between 50cm and 250cm", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (weightNumberInput.toInt() !in 3..200) {
                Toast.makeText(this, "Weight must be between 3kg and 200kg", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            saveData(
                this,
                nameTextInput,
                surnameTextInput,
                ageNumberInput.toInt(),
                highNumberInput.toInt(),
                weightNumberInput.toInt()
            )
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
//            Toast.makeText(this, getPersonList(this).toString(), Toast.LENGTH_LONG).show()

        }
    }
}