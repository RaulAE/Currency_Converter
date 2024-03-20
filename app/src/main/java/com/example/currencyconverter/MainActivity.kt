package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertNum = findViewById<EditText>(R.id.idConvertNumber)
        val rbPesoToUSD = findViewById<RadioButton>(R.id.idRBPesoToUSD)
        val rbUSDToPeso = findViewById<RadioButton>(R.id.idRBUSDToPeso)
        val txtResult = findViewById<TextView>(R.id.idResult)
        val convertIt = findViewById<Button>(R.id.idBtnConvert)

        convertIt.setOnClickListener{
            val tenth = DecimalFormat("$#.##")
            var dblMeasure = convertNum.text.toString().toDouble()
            val conversionRate = 16.81
            var convertMeasureNum: Double?

            if (rbUSDToPeso.isChecked) {
                if (dblMeasure <= 10000) {
                    convertMeasureNum = dblMeasure * conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + " Peso"
                } else {
                    Toast.makeText(this@MainActivity, "USD must be lass than $10,000", Toast.LENGTH_LONG).show()
                }
            }

            if (rbPesoToUSD.isChecked) {
                if (dblMeasure <= 100000) {
                    convertMeasureNum = dblMeasure / conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + " USD"
                } else {
                    Toast.makeText(this@MainActivity, "Pesos must be lass than $100,000", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}