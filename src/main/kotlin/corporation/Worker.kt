package corporation

import javax.swing.text.Position

open class Worker(
    val id: Int = 0,
    val name: String,
    val age: Int = 0,
    val workerType: WorkerType
) {
    open fun work() {
        println("working...")
    }

    open fun printInfo() {
        println("Id: $id Name: $name Age: $age Position: $workerType")
    }
}