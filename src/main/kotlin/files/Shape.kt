package files

import kotlin.math.PI
import kotlin.math.round

fun main() {
    val shape = Circle("Круг", 5.0)
    println(shape.area())
    println(shape.perimeter())
}

abstract class Shape(
    val name: String
) {
    abstract fun area(): Double
    abstract fun perimeter(): Double
    protected fun roundToTwoDecimals(value: Double): Double {
        val roundedValue = round(value * 100) / 100
        return roundedValue
    }
}

class Circle(
    name: String = "Круг",
    val radius: Double
): Shape(name = name) {

    override fun area(): Double {
        val value = PI*radius*radius
        val roundedValue = roundToTwoDecimals(value)
        return roundedValue
    }
    override fun perimeter(): Double {
        val value = 2*PI*radius
        val roundedValue = roundToTwoDecimals(value).toDouble()
        return roundedValue
    }
}

class Rectangle(
    name: String = "Треугольник",
    val width: Double,
    val height: Double
): Shape(name = name) {
    override fun area(): Double {
        val value = width*height
        val roundedValue = roundToTwoDecimals(value)
        return roundedValue
    }
    override fun perimeter(): Double {
        val value = 2 * (width + height)
        val roundedValue = roundToTwoDecimals(value)
        return roundedValue
    }
}