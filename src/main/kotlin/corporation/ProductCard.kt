package corporation

open class ProductCard (
   val name: String,
   val brand: String,
   val price: Int,
   val productType: ProductType
){

   open fun printInfo() {
      print("Name: $name Brand: $brand Price: $price Product type: ${productType.title}")
   }


}

