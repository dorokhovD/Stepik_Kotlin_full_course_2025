package org.example.profile

fun main() {


    print("Input 1st name: ")
    val firstName = readln()

    print("Input 1st surname: ")
    val firstSurName = readln()

    print("Input 1st age: ")
    val firstAge = readln().toInt()

    print("Input 1st height: ")
    val firstHeight = readln().toInt()

    print("Input 1st weight: ")
    val firstWeight = readln().toInt()

    val first = Person(name = firstName, height = firstAge, weight = firstWeight, surname = firstSurName)

    first.age = firstAge
    first.printInfo()
    first.sayhello()
    println(first.fullName)
}