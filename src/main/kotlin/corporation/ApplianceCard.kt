package corporation

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val wattage:  Int

): ProductCard(name = name, brand = brand, price = price, productType = ProductType.APPLIANCE) {

    override fun printInfo() {
        super.printInfo()
        print(" Wattage: $wattage\n")
    }
}