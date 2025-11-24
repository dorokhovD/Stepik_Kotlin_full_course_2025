package cats

import cats.Cat
import cats.Lion

fun main() {
    val cat = Cat("Sam")
    val lion = Lion(5)
    val animals = listOf<CatsFamily>(cat, lion)

    for (animal in animals) {
        animal.eat()
    }
//    cat.eat()
//    lion.eat()
}