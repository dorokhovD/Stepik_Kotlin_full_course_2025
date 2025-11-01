package corporation
import java.io.File

class Accountant(
    name: String,
    age: Int = 0
): Worker(name = name, age = age) {
    val file = File("product_cards.txt")

    override fun work() {
        val operationCodes = OperationCode.entries

        while (true) {
            print("Enter the operation code. ")

            for ((index, code) in operationCodes.withIndex()) {
                print("$index - ${code.title}")
                if (index < operationCodes.size - 1) {
                    print(", ")
                } else {
                    print(": ")
                }
            }
            val operationCodeIndex = readln().toInt()
            val operationCode = operationCodes[operationCodeIndex]
            when (operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
            }
        }
    }

    fun removeProductCard() {
        val cards: MutableList<ProductCard> = loadAllCards()
        print("Enter card name for removing: ")
        val name = readln()
        for (card in cards) {
            if (card.name == name) {
                cards.remove(card)
                break
            }
        }
        file.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }

    }

    fun loadAllCards(): MutableList<ProductCard> {
        val cards: MutableList<ProductCard> = mutableListOf<ProductCard>()
        //коллекция строк из файла
        val content = file.readText().trim()
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

    fun showAllItems() {
        val cards = loadAllCards()
        for (card in cards) {
            card.printInfo()
        }
    }

    fun saveProductCardToFile(productCard: ProductCard) {
        file.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is FoodCard -> {
                val caloric = productCard.caloric
                file.appendText("$caloric%")
            }

            is ShoeCard -> {
                val size = productCard.size
                file.appendText("$size%")
            }

            is ApplianceCard -> {
                val wattage = productCard.wattage
                file.appendText("$wattage%")
            }
        }
        file.appendText("${productCard.productType}\n")
    }

    fun registerNewItem() {
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

