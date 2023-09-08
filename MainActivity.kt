package com.example.application1
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputValue: EditText
    private lateinit var conversionSpinner: Spinner
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputValue = findViewById(R.id.inputValue)
        conversionSpinner = findViewById(R.id.conversionSpinner)
        convertButton = findViewById(R.id.convertButton)
        resultTextView = findViewById(R.id.resultTextView)

        // Define an array of conversion options
        val conversionOptions = arrayOf("Centimeters to Meters", "Grams to Kilograms", "Centimeters to Feet", "Grams to Pounds")

        // Create an ArrayAdapter to populate the Spinner with conversion options
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        conversionSpinner.adapter = adapter

        convertButton.setOnClickListener {
            val inputValue = inputValue.text.toString().toDouble()
            val selectedItem = conversionSpinner.selectedItemPosition

            val result: String = when (selectedItem) {
                0 -> "${inputValue} cm = ${inputValue / 100.0} meters"
                1 -> "${inputValue} grams = ${inputValue / 1000.0} kilograms"
                2 -> "${inputValue} cm = ${inputValue * 0.0328084} feet"
                3 -> "${inputValue} grams = ${inputValue * 0.00220462} pounds"
                else -> "Invalid selection"
            }

            resultTextView.text = result
        }
    }
}
