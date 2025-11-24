package corporation

abstract class ProductCard (
   open val name: String,
   open val brand: String,
   open val price: Int,
   val productType: ProductType
){
   fun printInfo() {
      println(this)
   }

}


//print("Name: $name Brand: $brand Price: $price Product type: ${productType.title}")