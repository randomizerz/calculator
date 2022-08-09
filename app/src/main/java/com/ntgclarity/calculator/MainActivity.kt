package com.ntgclarity.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var isTypingNumber = true
    private var tvResult: TextView? = null
    private val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById<TextView>(R.id.tv_result)
        val btnOne = findViewById<Button>(R.id.btn_one)
        val btnTwo = findViewById<Button>(R.id.btn_two)
        val btnThree = findViewById<Button>(R.id.btn_three)
        val btnFour = findViewById<Button>(R.id.btn_four)
        val btnFive = findViewById<Button>(R.id.btn_five)
        val btnSix = findViewById<Button>(R.id.btn_six)
        val btnSeven = findViewById<Button>(R.id.btn_seven)
        val btnEight = findViewById<Button>(R.id.btn_eight)
        val btnNine = findViewById<Button>(R.id.btn_nine)
        val btnZero = findViewById<Button>(R.id.btn_zero)
        val btnClear = findViewById<Button>(R.id.btn_clear)
        val btnMultiply = findViewById<Button>(R.id.btn_multiply)
        val btnDivision = findViewById<Button>(R.id.btn_division)
        val btnMinus = findViewById<Button>(R.id.btn_minus)
        val btnPlus = findViewById<Button>(R.id.btn_plus)
        val btnSqrt = findViewById<Button>(R.id.btn_sqrt)



        btnOne.setOnClickListener {
            handleDigitClick(1)
        }

        btnTwo.setOnClickListener {
            handleDigitClick(2)
        }

        btnThree.setOnClickListener {
            handleDigitClick(3)
        }

        btnFour.setOnClickListener {
            handleDigitClick(4)
        }

        btnFive.setOnClickListener {
            handleDigitClick(5)
        }

        btnSix.setOnClickListener {
            handleDigitClick(6)
        }

        btnSeven.setOnClickListener {
            handleDigitClick(7)
        }

        btnEight.setOnClickListener {
            handleDigitClick(8)
        }

        btnNine.setOnClickListener {
            handleDigitClick(9)
        }

        btnZero.setOnClickListener {
            handleDigitClick(0)
        }


        btnPlus.setOnClickListener {
            handleOperation("+")
        }

        btnSqrt.setOnClickListener {
            handleOperation("sqrt")
        }

        btnMinus.setOnClickListener {
            handleOperation("-")
        }

        btnMultiply.setOnClickListener {
            handleOperation("*")
        }

        btnDivision.setOnClickListener {
            handleOperation("/")
        }

        btnClear.setOnClickListener {
            if (isTypingNumber) {
                isTypingNumber = false
            }
            tvResult?.text = "0.0"
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

    fun handleOperation(operation:String)
    {
        if (isTypingNumber) {
            isTypingNumber = false
        }

        val numberOnDisplay = tvResult?.text.toString().toDouble()

        calculator.operand = numberOnDisplay

        val result = calculator.execute(operation)

        tvResult?.text = "${result}"

    }
}