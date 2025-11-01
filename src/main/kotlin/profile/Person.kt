package org.example.profile

class Person {
    val name: String
    val age: Int
    val height: Int
    val weight: Int

    constructor(name: String, age: Int, height: Int, weight: Int) {
        this.name = name
        this.age = age
        this.height = height
        this.weight = weight
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