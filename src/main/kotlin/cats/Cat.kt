package cats

class Cat(val name: String): CatsFamily() {

    fun playWithMouse() {
        println("Playing with mouse")
    }
}