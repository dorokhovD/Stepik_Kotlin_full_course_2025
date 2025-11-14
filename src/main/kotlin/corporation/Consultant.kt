package corporation

import kotlin.random.Random

class Consultant(
    id: Int,
    name: String,
    age: Int = 0,
    salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    workerType = WorkerType.CONSULTANT,
    salary = salary,
), Cleaner {

    override fun clean() {
        println("My position is Consultant. I,m cleaning workplace...")
    }

    fun serveCustomers(): Int {
        val count = Random.nextInt(0, 10)
        repeat(count) {
            print("The customer is served... ")
        }
        println()
        return count
    }

    fun sayHello() {
        when {
            age > 0 -> println("Привет! Меня зовут $name. Мне $age лет.")
            else -> println("Привет! Меня зовут $name.")
        }
    }

    override fun work() {
        serveCustomers()
    }
}