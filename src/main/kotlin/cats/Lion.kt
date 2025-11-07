package cats

import cats.CatsFamily

class Lion(
    val countInPride: Int
): CatsFamily() {

    override fun eat() {
        println("eating Antilopa")

    }
}