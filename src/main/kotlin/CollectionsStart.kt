package org.example

fun main() {
    val month = listOf<Int>(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val number = readln().toInt()

    if (number < 1 || number > 12)
        println("Incorrect number!")
    else
        println(month[number - 1])
}