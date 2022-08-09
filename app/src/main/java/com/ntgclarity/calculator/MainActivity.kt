package com.ntgclarity.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var isTypingNumber = true
    private var tvResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById<TextView>(R.id.tv_result)
        val btnOne = findViewById<Button>(R.id.btn_one)
        val btnTwo = findViewById<Button>(R.id.btn_two)
        val btnPlus = findViewById<Button>(R.id.btn_plus)

        btnOne.setOnClickListener {
            handleDigitClick(1)
        }
        btnTwo.setOnClickListener {
            handleDigitClick(2)
        }

        val calculator = Calculator()

        btnPlus.setOnClickListener {
            if (isTypingNumber) {
                isTypingNumber = false
            }

            val numberOnDisplay = tvResult?.text.toString().toDouble()

            calculator.operand = numberOnDisplay

            val result = calculator.execute("+")

            tvResult?.text = "${result}"
        }
    }

    fun handleDigitClick(digit: Int) {
        if (isTypingNumber) {
            tvResult?.text = "${tvResult?.text}${digit}"
        } else {
            tvResult?.text = "${digit}"

            isTypingNumber = true
        }
    }

    fun sums() {
        val calculator = Calculator()
        val numbers = listOf(12.0, 20.0, 40.0)

        numbers.forEach {
            calculator.operand = it
            val result = calculator.execute("+")
            println("result: ${result}")
        }
    }
}