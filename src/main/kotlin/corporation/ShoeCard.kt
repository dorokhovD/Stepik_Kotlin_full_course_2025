package corporation

data class ShoeCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val size: Float

): ProductCard(name = name, brand = brand, price = price, productType = ProductType.SHOE) {

//    override fun toString(): String {
//        return "Name: $name Brand: $brand Price: $price Product type: ${productType.title} Size: $size\n"
//    }
}