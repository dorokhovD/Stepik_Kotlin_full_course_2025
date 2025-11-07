package corporation

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int

): ProductCard(name = name, brand = brand, price = price, productType = ProductType.FOOD) {

    override fun toString(): String {
        return "Name: $name Brand: $brand Price: $price Product type: ${productType.title} Caloric: $caloric\n"
    }
}