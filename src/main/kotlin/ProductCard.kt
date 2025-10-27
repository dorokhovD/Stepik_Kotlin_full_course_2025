package org.example

class ProductCard (
   var name: String,
   var brand: String,
   var size: Float,
   var price: Int
){
//   constructor(name: String, brand: String, size: Float, price: Int) {
//      this.name = name
//      this.brand = brand
//      this.size = size
//      this.price = price
//   }

   fun printInfo() {
      println("Name: $name Brand: $brand Size: $size Price: $price")
   }
}
class Consultant(
   val name: String,
   val age: Int = 0,
) {
   fun sayHello() {
      when {
        age > 0 -> println("Привет! Меня зовут $name. Мне $age лет.")
         else -> println("Привет! Меня зовут $name.")
      }
   }
}