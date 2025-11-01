package corporation

open class Worker(
    val name: String,
    val age: Int = 0
) {
    open fun work() {
        println("working...")
    }
}