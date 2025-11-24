package files

enum class OperationCode(val title: String) {
    EXIT(title = "Exit"), NEW_TODO(title = "new todo"), SHOW_LIST("show list")
}