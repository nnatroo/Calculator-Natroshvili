package com.example.mynnnatroshvili

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View
import android.view.Window

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operation: String = ""
    private var operand: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(clickedView: View) {
        if (clickedView is TextView) {

            var result = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number

        }
    }

    fun operationClick(clickedView: View) {
        if (clickedView is TextView) {
            val result: String = resultTextView.text.toString()

            if (result.isNotEmpty()) {
                operand = result.toDouble()
            }
            operation = clickedView.text.toString()

            resultTextView.text = ""

        }

    }

    fun equalClick(clickedView: View) {
        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (secOperandText.isNotEmpty()) {
            secOperand = secOperandText.toDouble()
        }
        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
            "| x |" -> resultTextView.text = (Math.abs(operand)).toString()
            "x²" -> resultTextView.text = (operand * operand).toString()
            "%" -> resultTextView.text = ((operand * secOperand)/100).toString()
            "√" -> resultTextView.text = ((Math.sqrt(operand)).toString())
            "." -> resultTextView.text = "."

        }

    }



    fun clearClick(clickedView: View) {
        if (clickedView is TextView) {

            var result = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = ""


        }
    }


}