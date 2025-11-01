package files

fun main() {
    val car = Car("Nissan", "X-Trail", 2015, "1337", "Gray")

    val order1 = Order(1, "completed", "electronics")
    val order2 = Order(2, "completed", "clothing")
    val order3 = Order(3, "canceled", "furniture")
    val order4 = Order(4, "completed", "clothing")

    val orders: List<Order> = listOf<Order>(order1, order2, order3, order4)
    val newOrders = removeCompletedOrders(orders, "clothing")

    for (order in newOrders) {
        println("${order.id} ${order.status} ${order.type}")
    }
//    println(serialize(car))
//    val carAsString = serialize(car)
//    println(deserialize(carAsString))
}
class Car(
    val make: String,
    val model: String,
    val year: Int,
    val vin: String,
    val color: String,
)

fun serialize(car: Car): String {
    val carAsString = ("${car.make}%${car.model}%${car.year}%${car.vin}%${car.color}")
    return carAsString
}

fun deserialize(carAsString: String): Car {
    val dCar = carAsString.trim().split("%")
    val carAsClass = Car(
        make = dCar[0],
        model = dCar[1],
        year = dCar[2].toInt(),
        vin = dCar[3],
        color = dCar[4]
    )
    return carAsClass
}

data class Order(
    val id: Int,
    val status: String,
    val type: String
)

fun removeCompletedOrders(orders: List<Order>, typeToRemove: String): List<Order> {
    val mutableOrders: MutableList<Order> = orders.toMutableList()
    for (order in orders) {
        if (order.type == typeToRemove && order.status == "completed") {
            mutableOrders.remove(order)
        }
    }
    return mutableOrders
}