package org.example.gui

class Rectangle(
    var width: Int = 0, //Ширина
    var height: Int = 0
) {

    val area: Int
        get() = width * height

    constructor(size: Int): this (size, size)

    fun draw() {
        var i = 0
        var j = 0
        while (i < height) {
            while (j < width) {
                print("* ")
                j++
            }
            println()
            i++
            j = 0
        }
    }

}