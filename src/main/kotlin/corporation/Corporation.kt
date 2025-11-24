package corporation

fun main() {

//    val director = Director(name = "Dima", age = 36)
//    val consultant = Consultant(name = "Dmitry", age = 26)
//    val assistant = Assistant(name = "Alisa", age = 25)
//    val accountant = Accountant(name = "Bob", age = 42)

//    val employees = listOf<Worker>(director, consultant, assistant, accountant)
//    for (employee in employees) {
//        employee.work()
//    }
    //val accountant = Accountant(0, "Bob", 25, salary = 100000)

//    val workers = WorkersRepository.workers
//
//    for (worker in workers) {
//        worker.work()
//    }

//    val assistant = WorkersRepository.findAssistant()
//
//    assistant?.printInfo()
//
//    val director = WorkersRepository.findDirector()
//
//    director?.printInfo()
//    if (assistant != null) {
//        director?.takeCoffee(assistant)
//    }
//
//    val directorSalary = director?.salary ?: 0
//    val assistantSalary = assistant?.salary ?: 0
//
//    val sum = directorSalary + assistantSalary

    val director = WorkersRepository.findDirector() ?: throwDirectorIsRequired()
    director.printInfo()

//    val shoeCard = ShoeCard(name = "Sneakers", brand = "Asics", size = 42f, price = 7000)
//    shoeCard.printInfo()
}

fun throwDirectorIsRequired(): Nothing {
    throw IllegalArgumentException("Директор требуется. Добавьте его в файл")
}