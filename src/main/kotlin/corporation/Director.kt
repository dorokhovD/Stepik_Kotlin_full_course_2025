package corporation

class Director(
    name: String,
    age: Int
): Worker(name = name) {

    fun takeCoffee(assistant: Assistant) {
        val drinkName: String = assistant.bringCoffee()
        println("Thanks, ${assistant.name} The $drinkName is tasty")
    }

    fun getConsultantToWork(consultant: Consultant) {
        val count = consultant.serveCustomers()
        println("Consultant ${consultant.name} served $count clients")
    }

    override fun work() {
        println("I'm drinking coffee...")
    }
}