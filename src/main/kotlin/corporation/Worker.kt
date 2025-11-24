package corporation

abstract class Worker(
       open val id: Int,
       open val name: String,
       open val age: Int = 0,
       open val salary: Int = 15000,
       open val workerType: WorkerType
) {

    abstract fun copy(
        id: Int = this.id,
        name: String = this.name,
        age: Int = this.age,
        salary: Int = this.salary,
        workerType: WorkerType = this.workerType
        ): Worker

    abstract fun work()

    fun printInfo() {
        println(this)
    }

//    override fun toString(): String {
//        return "Id: $id Name: $name Age: $age Position: $workerType Salary: $salary"
//    }
//
//    override fun equals(other: Any?): Boolean {
//        if (other !is Worker) return false
//
//        return id == other.id && name == other.name && age == other.age && salary == other.salary && workerType == other.workerType
//    }
//
//    override fun hashCode(): Int {
//        var result = id
//        result = 31 * result + age
//        result = 31 * result + salary
//        result = 31 * result + name.hashCode()
//        result = 31 * result + workerType.hashCode()
//        return result
//    }


}
