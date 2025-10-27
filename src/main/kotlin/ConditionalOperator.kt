package org.example

fun main() {
    print("Type month: ")
    val month = readln()
    val timeYear = when (month) {
        "December","January","February"  -> "Winter"
        "March","April","May" -> "Spring"
        "June", "July","August" -> "Summer"
        "September","October","November" -> "Autumn"
        else -> "Error type month"
    }
    println(timeYear)
}