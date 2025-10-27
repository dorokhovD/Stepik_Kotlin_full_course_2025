package org.example

class Rectangle {

    val width: Int //Ширина
    val length: Int //Длина

    constructor(): this(0)

    constructor(width: Int, length: Int) {
        this.width = width
        this.length = length
    }

    constructor(size: Int): this (size, size)

    fun draw() {
        var i = 0
        var j = 0
        while (i < length) {
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