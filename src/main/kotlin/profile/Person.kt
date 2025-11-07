package org.example.profile

class Person {
    private val name: String
    private val age: Int
    private val height: Int
    private val weight: Int

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