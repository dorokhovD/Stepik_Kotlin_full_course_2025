package corporation

fun main() {

    val director = Director(name = "Dima", age = 36)
    val consultant = Consultant(name = "Dmitry", age = 26)
    val assistant = Assistant("Alisa", age = 25)
    val accountant = Accountant("Bob", 42)

    val employees = listOf<Worker>(director, consultant, assistant, accountant)
    for (employee in employees) {
        employee.work()
    }

//    val shoeCard = ShoeCard(name = "Sneakers", brand = "Asics", size = 42f, price = 7000)
//    shoeCard.printInfo()
}