package corporation

import javax.swing.text.Position

abstract class Worker(
       val id: Int = 0,
       val name: String,
       val age: Int = 0,
       private var salary: Int = 15000,
       val workerType: WorkerType
) {


        fun getSalary() = this.salary


        fun setSalary(salary: Int) {
        if (salary < this.salary) {
            println("The new salary is too small...")
        } else {
            this.salary = salary
        }
    }

    abstract fun work()

    fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "Id: $id Name: $name Age: $age Position: $workerType Salary: $salary"
    }
}
