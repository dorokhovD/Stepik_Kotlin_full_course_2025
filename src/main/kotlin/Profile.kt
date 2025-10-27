package org.example

fun main() {


    print("Input 1st name: ")
    val firstName = readln()

    print("Input 2st name: ")
    val secondName = readln()


    print("Input 1st age: ")
    val firstAge = readln().toInt()

    print("Input 2st age: ")
    val secondAge = readln().toInt()

    print("Input 1st height: ")
    val firstHeight = readln().toInt()

    print("Input 2st height: ")
    val secondHeight = readln().toInt()

    print("Input 1st weight: ")
    val firstWeight = readln().toInt()

    print("Input 2st weight: ")
    val secondWeight = readln().toInt()

    val first = Person(name = firstName, age = firstAge, height = firstAge, weight = firstWeight)
    val second = Person(name = secondName, age = secondAge, height = secondAge, weight = secondWeight)

    first.printInfo()
    second.printInfo()

    first.sayhello()
    second.sayhello()
}