package corporation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int = 0,
): Worker(name = name, age = age) {

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