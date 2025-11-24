package corporation

data class ApplianceCard(
  override val name: String,
  override val brand: String,
  override val price: Int,
  val wattage:  Int

): ProductCard(name = name, brand = brand, price = price, productType = ProductType.APPLIANCE) {

//    override fun toString(): String {
//        return "Name: $name Brand: $brand Price: $price Product type: ${productType.title} Wattage: $wattage\n"
//    }
}