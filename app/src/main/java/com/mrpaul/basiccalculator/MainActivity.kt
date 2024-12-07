package com.mrpaul.basiccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var input = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        // Buttons for digits and operators
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button0: Button = findViewById(R.id.button0)

        val buttonPlus: Button = findViewById(R.id.buttonPlus)
        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)

        // Operators and clear button
        val buttonClear: Button = findViewById(R.id.buttonClear)
        val buttonEqual: Button = findViewById(R.id.buttonEqual)

        // Number buttons click listeners
        button7.setOnClickListener { appendToInput("7") }
        button8.setOnClickListener { appendToInput("8") }
        button9.setOnClickListener { appendToInput("9") }
        button4.setOnClickListener { appendToInput("4") }
        button5.setOnClickListener { appendToInput("5") }
        button6.setOnClickListener { appendToInput("6") }
        button1.setOnClickListener { appendToInput("1") }
        button2.setOnClickListener { appendToInput("2") }
        button3.setOnClickListener { appendToInput("3") }
        button0.setOnClickListener { appendToInput("0") }

        // Operator buttons click listeners
        buttonPlus.setOnClickListener { appendToInput("+") }
        buttonMinus.setOnClickListener { appendToInput("-") }
        buttonMultiply.setOnClickListener { appendToInput("*") }
        buttonDivide.setOnClickListener { appendToInput("/") }

        // Clear button
        buttonClear.setOnClickListener { clearInput() }

        // Equals button
        buttonEqual.setOnClickListener { calculateResult() }
    }

    private fun appendToInput(value: String) {
        input.append(value)
        display.text = input.toString()
    }

    private fun clearInput() {
        input.clear()
        display.text = "0"
    }

    private fun calculateResult() {
        try {
            val result = evaluateExpression(input.toString())
            input.clear()
            input.append(result)
            display.text = result.toString()
        } catch (e: Exception) {
            display.text = "Error"
        }
    }

    private fun evaluateExpression(expression: String): Double {
        return expression.toDouble()
    }
}