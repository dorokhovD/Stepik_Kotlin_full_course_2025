package corporation

import java.io.File

class WorkersRepository {

    private val fileWorkers = File("workers.txt")
    val workers = loadAllEmployees()


    fun registerNewEmployee(worker: Worker) {
        workers.add(worker)
    }

    fun changeSalary(id: Int, salary: Int) {
        for (worker in workers) {
            if (worker.id == id) {
                worker.setSalary(salary)
            }
        }
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (worker in workers) {
            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.workerType}\n")
        }
        fileWorkers.writeText(content.toString())
    }

    fun fireAnEmployee(id: Int) {
        for (worker in workers) {
            if (worker.id == id) {
                workers.remove(worker)
                break
            }
        }
    }

    private fun loadAllEmployees(): MutableList<Worker> {
        val workers = mutableListOf<Worker>()

        if (!fileWorkers.exists()) fileWorkers.createNewFile()

        val content = fileWorkers.readText().trim()// обрезать лишние пробелы и переносы
        if (content.isEmpty()) return workers

        val workersAsString = content.split("\n")
        for (cardAsString in workersAsString) {
            val properties = cardAsString.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val salary = properties[3].toInt()
            val type = properties.last()
            val workerType = WorkerType.valueOf(type)
            val worker = when(workerType) {
                WorkerType.DIRECTOR -> Director(id, name, age, salary)
                WorkerType.ACCOUNTANT -> Accountant(id, name, age, salary)
                WorkerType.ASSISTANT -> Assistant(id, name, age, salary)
                WorkerType.CONSULTANT -> Consultant(id, name, age, salary)
            }
            workers.add(worker)
        }
        return workers
    }
}