package org.example
fun main() {
    val numbers = 0 ..1000 step 2
    val num = readln().toInt()
    for (number in numbers) {

        if (num == number && num % 2 == 0)
            println("Входит")

    }
}