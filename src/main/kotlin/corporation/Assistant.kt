package corporation

class Assistant(
    id: Int,
    name: String,
    age: Int = 0
): Worker(id = id, name = name, age = age, WorkerType.ASSISTANT), Cleaner, Supplier {

    override fun clean() {
        println("My position is Assistant. I,m cleaning workplace...")
    }

    override fun buyThings() {
        println("I'm buying things..")
    }

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