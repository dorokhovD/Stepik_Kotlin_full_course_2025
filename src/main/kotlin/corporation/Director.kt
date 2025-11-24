package corporation

data class Director(
    override val id: Int,
    override val name: String,
    override val age: Int,            
    override val salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    workerType = WorkerType.DIRECTOR,
    salary = salary
), Supplier {

    override fun buyThings() {
        println("I'm buying things..")
    }

    override fun copy(id: Int, name: String, age: Int, salary: Int, workerType: WorkerType): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

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