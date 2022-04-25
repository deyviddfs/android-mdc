package br.com.deyvidfernandes.androidmdc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .build()

        val outlinedEditTextFieldBirthday = findViewById<TextInputEditText>(R.id.outlinedEditTextFieldBirthday)
        val imageButtonCalendar = findViewById<ImageButton>(R.id.imageButtonCalendar)

        imageButtonCalendar.setOnClickListener {
            datePicker.show(supportFragmentManager, "DatePicker")
        }

        // Setting up the event for when ok is clicked
        datePicker.addOnPositiveButtonClickListener {
            val dateFormatter = SimpleDateFormat("dd/MM/yyyy")
            val date = dateFormatter.format(Date(it))
            outlinedEditTextFieldBirthday.setText(date)
        }
    }
}