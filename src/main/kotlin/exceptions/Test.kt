package exceptions

fun main() {
val a = listOf<Int>(0,1,2,3)

    try {
        print(a[4])
    } catch (exception: Throwable) {
        print("Error")
    }
}