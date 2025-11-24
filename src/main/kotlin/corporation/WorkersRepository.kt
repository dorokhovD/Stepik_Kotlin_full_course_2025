package corporation

import java.io.File

object WorkersRepository {

    private val fileWorkers = File("workers.txt")
    private val _workers = loadAllEmployees()
    val workers
        get() = _workers.toList()

    fun registerNewEmployee(newWorker: Worker) {
        _workers.add(newWorker)
    }

    fun findAssistant(): Assistant? {
        for (worker in _workers) {
            if (worker is Assistant) {
                return worker
            }
        }
        return null
    }

    fun findDirector(): Director? {
        for (worker in _workers) {
            if (worker is Director) {
                return worker
            }
        }
        return null
    }

    fun changeAge(id: Int, age: Int) {
        for ( worker in _workers) {
            if (worker.id == id) {
                val newWorker = worker.copy(age = age)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun changeSalary(id: Int, salary: Int) {
        for ( worker in _workers) {
            if (worker.id == id) {
                val newWorker = worker.copy(salary = salary)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (worker in _workers) {
            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.salary}%${worker.workerType}\n")
        }
        fileWorkers.writeText(content.toString())
    }

    fun fireAnEmployee(id: Int) {
        for (worker in _workers) {
            if (worker.id == id) {
                _workers.remove(worker)
                break
            }
        }
    }

    private fun loadAllEmployees(): MutableSet<Worker> {
        println("loadAllEmployees")
        val workers = mutableSetOf<Worker>()

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
            val worker = when (workerType) {
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