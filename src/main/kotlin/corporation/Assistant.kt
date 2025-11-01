package corporation

class Assistant(
    name: String,
    age: Int = 0
): Worker(name = name, age = age) {

    fun bringCoffee(drinkName: String = "Cappuccino", count: Int = 1): String {
        repeat(count) {
            println("press the \"$drinkName\" button")
            println("wait for the $drinkName to be prepared")
        }
        return drinkName
    }

    override fun work() {
        println("I'm answer for phone")
    }
}