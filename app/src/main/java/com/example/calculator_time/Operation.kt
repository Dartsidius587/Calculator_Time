package com.example.calculator_time

class Operation(var operandOne: String, var operandTwo: String): Translation() {
    fun sum() = toTime(timeToInt(operandOne) + timeToInt(operandTwo))
    fun dif() = toTime(timeToInt(operandOne) - timeToInt(operandTwo))
}