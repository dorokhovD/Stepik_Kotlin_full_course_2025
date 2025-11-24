package corporation

import javax.swing.text.Position

data class Accountant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    workerType = WorkerType.ACCOUNTANT
), Cleaner, Supplier {

    private val workersRepository = WorkersRepository
    private val productCardsRepository = ProductCardsRepository


    override fun clean() {
        println("My position is Accountant. I,m cleaning workplace...")
    }

    override fun buyThings() {
        println("I'm buying things..")
    }

    override fun work() {

        val operationCodes = OperationCode.entries

        while (true) {
            println("Enter the operation code. ")

            for ((index, code) in operationCodes.withIndex()) {
                println("$index - ${code.title}")
            }
            val operationCodeIndex = readln().toInt()
            val operationCode = operationCodes[operationCodeIndex]
            when (operationCode) {
                OperationCode.EXIT -> {
                    workersRepository.saveChanges()
                    productCardsRepository.saveChanges()
                    break
                }
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> fireAnEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
                OperationCode.CHANGE_AGE -> changeAge()
            }
        }
    }

    private fun changeAge() {
        print("Enter employee's id to change age: ")
        val id = readln().toInt()
        print("Enter new age: ")
        val age = readln().toInt()
        workersRepository.changeAge(id = id, age = age)
    }

    private fun changeSalary() {
        print("Enter employee's id to change salary: ")
        val id = readln().toInt()
        print("Enter new salary: ")
        val salary = readln().toInt()
        workersRepository.changeSalary(id = id, salary = salary)
    }

    private fun registerNewEmployee() {
        val workerTypes = WorkerType.entries
        print("Choose position - ")
        for ((index, type) in workerTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < workerTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val positionTypeIndex = readln().toInt()
        val workerType = workerTypes[positionTypeIndex]
        print("Enter id: ")
        val id = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter age: ")
        val age = readln().toInt()
        print("Enter salary: ")
        val salary = readln().toInt()
        val worker = when (workerType) {
            WorkerType.DIRECTOR -> Director(id, name, age, salary)
            WorkerType.ACCOUNTANT -> Accountant(id, name, age, salary)
            WorkerType.ASSISTANT -> Assistant(id, name, age, salary)
            WorkerType.CONSULTANT -> Consultant(id, name, age, salary)
        }
        workersRepository.registerNewEmployee(worker)
    }

    override fun copy(id: Int, name: String, age: Int, salary: Int, workerType: WorkerType): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

    private fun fireAnEmployee() {
        print("Enter employee's id to fire: ")
        val id = readln().toInt()
       workersRepository.fireAnEmployee(id)
    }

    private fun showAllEmployees() {
        val workers = workersRepository.workers
        for (worker in workers) {
            worker.printInfo()
        }
    }

    private fun removeProductCard() {
        print("Enter card name for removing: ")
        val name = readln()
        productCardsRepository.removeProductCard(name)
    }


    private fun showAllItems() {
        val cards = productCardsRepository.productCards
        for (card in cards) {
            card.printInfo()
        }
    }


    private fun registerNewItem() {
        val productTypes = ProductType.entries
        print("Enter the product type. ")
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < productTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val productTypeIndex = readln().toInt()
        val productType = productTypes[productTypeIndex]
        print("Enter the product name: ")
        val productName = readln()
        print("Enter the product brand: ")
        val productBrand = readln()
        print("Enter the product price: ")
        val productPrice = readln().toInt()
        //ProductType.valueOf("FOOD")
        val card = when (productType) {
            ProductType.FOOD -> {
                print("Enter the product caloric: ")
                val caloric = readln().toInt()
                FoodCard(productName, productBrand, productPrice, caloric)

            }

            ProductType.APPLIANCE -> {
                print("Enter the product wattage: ")
                val wattage = readln().toInt()
                ApplianceCard(productName, productBrand, productPrice, wattage)
            }

            ProductType.SHOE -> {
                print("Enter the product size: ")
                val size = readln().toFloat()
                ShoeCard(productName, productBrand, productPrice, size)
            }
        }
        productCardsRepository.registerNewItem(card)
    //items.add(card)
    //card.printInfo()
    }



}

