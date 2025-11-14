package org.example.profile

class Person(
    private val name: String,
    val surname: String,
    private val height: Int,
    private val weight: Int
) {

    val fullName: String
        get() = "$name $surname"

    var age: Int = 0
        set(value) {
            if (value > field) {
                field = value
            } else {
                println("The new age must be bigger than old one")
            }
        }
        get() {
            println("Спрашивать возраст неприлично")
            return field
        }

    fun sayhello() {
        println("Hello! My name is $name")
    }
    fun printInfo() {
        println("Name: $name Age: $age Height: $height Weight: $weight")
    }

    fun run() {
        repeat(10) {
            print("Running... ")
        }
        print("\n")
    }

}