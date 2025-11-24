package org.example.gui

fun main() {
    val rectangle = Rectangle(width = 1, height = 4)
    println(rectangle.area)
    rectangle.height = 10
    println(rectangle.area)
}