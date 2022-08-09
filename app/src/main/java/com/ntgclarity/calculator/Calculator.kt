package com.ntgclarity.calculator

class Calculator {
    var operand = 0.0
    private var result = 0.0

    fun execute(operation: String): Double {
        if (operation == "+") {
            operand = result + operand
            result = operand
        }

        return operand
    }
}