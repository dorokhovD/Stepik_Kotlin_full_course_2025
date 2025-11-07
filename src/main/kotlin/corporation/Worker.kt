package corporation

import javax.swing.text.Position

abstract class Worker(
       val id: Int = 0,
       val name: String,
       val age: Int = 0,
       val workerType: WorkerType
) {
    abstract fun work()

    fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "Id: $id Name: $name Age: $age Position: $workerType"
    }
}
