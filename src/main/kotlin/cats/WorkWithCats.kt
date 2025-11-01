package cats

import cats.Cat
import cats.Lion

fun main() {
    val cat = Cat("Sam")
    println(cat.legsCount)
    println(cat.name)

    val lion = Lion(5)
    println(lion.legsCount)
    println(lion.countInPride)

    println(cat.playWithMouse())
}