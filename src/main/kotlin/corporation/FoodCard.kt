package corporation

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int

): ProductCard(name = name, brand = brand, price = price, productType = ProductType.FOOD) {

    override fun printInfo() {
        super.printInfo()
        print(" Caloric: $caloric\n")
    }
}