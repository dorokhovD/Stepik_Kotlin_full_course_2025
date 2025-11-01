package corporation

class ShoeCard(
    name: String,
    brand: String,
    price: Int,
    val size: Float

): ProductCard(name = name, brand = brand, price = price, productType = ProductType.SHOE) {

    override fun printInfo() {
        super.printInfo()
        print(" Size: $size\n")
    }
}