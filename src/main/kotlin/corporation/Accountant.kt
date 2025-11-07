package corporation
import java.io.File

class Accountant(
    id: Int,
    name: String,
    age: Int = 0
): Worker(id = id, name = name, age = age, WorkerType.ACCOUNTANT), Cleaner, Supplier {
    private val fileProductCard = File("product_cards.txt")
    private val fileWorkers = File("workers.txt")

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
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> fireAnEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
            }
        }
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
        val worker = when (workerType) {
            WorkerType.DIRECTOR -> Director(id, name, age)
            WorkerType.ACCOUNTANT -> Accountant(id, name, age)
            WorkerType.ASSISTANT -> Assistant(id, name, age)
            WorkerType.CONSULTANT -> Consultant(id, name, age)
        }
        saveWorkerToFile(worker)
    }

    private fun fireAnEmployee() {
        val workers: MutableList<Worker> = loadAllEmployees()
        print("Enter employee's id to fire: ")
        val workerRemoveId = readln().toInt()
        fileWorkers.writeText("")
        for (worker in workers) {
            if (worker.id != workerRemoveId) {
                saveWorkerToFile(worker)
            }
        }
    }

    private fun showAllEmployees() {
        val workers = loadAllEmployees()
        for (worker in workers) {
            worker.printInfo()
        }
    }

    private fun saveWorkerToFile(worker: Worker) {
        fileWorkers.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.workerType}\n")
    }

    fun loadAllEmployees(): MutableList<Worker> {
        val workers = mutableListOf<Worker>()

        if (!fileWorkers.exists()) fileWorkers.createNewFile()

        val content = fileWorkers.readText().trim()// обрезать лишние пробелы и переносы
        if (content.isEmpty()) return workers

        val workersAsString = content.split("\n")
        for (cardAsString in workersAsString) {
            val properties = cardAsString.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val type = properties.last()
            val workerType = WorkerType.valueOf(type)
            val worker = when(workerType) {
                WorkerType.DIRECTOR -> Director(id, name, age)
                WorkerType.ACCOUNTANT -> Accountant(id, name, age)
                WorkerType.ASSISTANT -> Assistant(id, name, age)
                WorkerType.CONSULTANT -> Consultant(id, name, age)
            }
            workers.add(worker)
        }
        return workers
    }

    private fun removeProductCard() {
        val cards: MutableList<ProductCard> = loadAllCards()
        print("Enter card name for removing: ")
        val name = readln()
        for (card in cards) {
            if (card.name == name) {
                cards.remove(card)
                break
            }
        }
        fileProductCard.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }
    }

    private fun loadAllCards(): MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()
        //коллекция строк из файла
        if (!fileProductCard.exists()) fileProductCard.createNewFile()
        val content = fileProductCard.readText().trim()
        if (content.isEmpty()) {
            return cards
        }
        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val properties = cardAsString.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when(productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }
                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }
                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    private fun showAllItems() {
        val cards = loadAllCards()
        for (card in cards) {
            card.printInfo()
        }
    }

    private fun saveProductCardToFile(productCard: ProductCard) {
        fileProductCard.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is FoodCard -> {
                val caloric = productCard.caloric
                fileProductCard.appendText("$caloric%")
            }

            is ShoeCard -> {
                val size = productCard.size
                fileProductCard.appendText("$size%")
            }

            is ApplianceCard -> {
                val wattage = productCard.wattage
                fileProductCard.appendText("$wattage%")
            }
        }
        fileProductCard.appendText("${productCard.productType}\n")
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
        saveProductCardToFile(card)
    //items.add(card)
    //card.printInfo()
    }



}

