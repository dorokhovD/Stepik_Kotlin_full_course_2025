package corporation

class FoodCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val caloric: Int

): ProductCard(name = name, brand = brand, price = price, productType = ProductType.FOOD) {

//    override fun toString(): String {
//        return "Name: $name Brand: $brand Price: $price Product type: ${productType.title} Caloric: $caloric\n"
//    }
}