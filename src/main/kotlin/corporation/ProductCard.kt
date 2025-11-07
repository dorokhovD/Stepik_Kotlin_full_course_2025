package corporation

abstract class ProductCard (
   val name: String,
   val brand: String,
   val price: Int,
   val productType: ProductType
){
   fun printInfo() {
      print(this)
   }

}


//print("Name: $name Brand: $brand Price: $price Product type: ${productType.title}")