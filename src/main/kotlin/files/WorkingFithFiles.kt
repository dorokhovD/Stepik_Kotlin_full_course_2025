package files

import java.io.File

val toDoList = File("toDoList.txt")

fun main() {
    //val file = File("test.txt")
    //file.appendText("Hello")


    val operationCodes = OperationCode.entries

    while(true) {
        print("choice: ")
        for ((index, code) in operationCodes.withIndex()) {
            print("$index - ${code.title}")
            if (index < operationCodes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val operationCodesIndex = readln().toInt()
        val operationCode = operationCodes[operationCodesIndex]

        when (operationCode) {
            OperationCode.EXIT -> break
            OperationCode.NEW_TODO -> appendText()
            OperationCode.SHOW_LIST -> showList()
        }


    }

}
fun showList() {
    //val list = listOf(toDoList.readLines())
    var i = 0
    for (item in toDoList.readLines()) {
        println("$i - $item")
        i++
    }
}

fun appendText() {
    val todo = readln()
    toDoList.appendText("$todo\n")
}