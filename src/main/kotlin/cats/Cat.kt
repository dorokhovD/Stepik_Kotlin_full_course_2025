package cats

class Cat(val name: String): CatsFamily() {

    fun playWithMouse() {
        println("Playing with mouse")
    }

    override fun eat() {
        println("eating whiskas")

    }
}