package com.example.calculator

class SimpleExpression {
    var operand1 = 0
    var operand2 = 0
    var operator = "."

    private var nValue = 0

    val value: Int
        get() {
            computeValue()
            return nValue
        }

//    clears the operands within an expression
    fun clearOperands() {
        operand1 = 0
        operand2 = 0
    }

//    Computes the integer value of the expression

    private fun computeValue()
    {
        nValue = 0

        nValue =
            if (operator.contentEquals( charSequence = "+"))
                operand1 + operand2

            else if (operator.contentEquals(charSequence = "-"))
                operand1 - operand2

            else if (operator.contentEquals(charSequence = "/") && operand2 != 0)
                operand1 / operand2 else operand1 % operand2

        clearOperands()
    }
}