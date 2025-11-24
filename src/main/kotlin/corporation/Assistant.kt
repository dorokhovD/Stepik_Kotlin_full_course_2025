package corporation

data class Assistant(
    override val id: Int,
    override val name: String,
    override val age: Int = 0,
    override val salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    workerType = WorkerType.ASSISTANT
), Cleaner, Supplier {

    override fun copy(id: Int, name: String, age: Int, salary: Int, workerType: WorkerType): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

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