package corporation

enum class OperationCode(val title: String, ) {
    EXIT(title = "Exit"),
    REGISTER_NEW_ITEM(title = "Register new item"),
    SHOW_ALL_ITEMS("show all items"),
    REMOVE_PRODUCT_CARD("Remove product card"),
    REGISTER_NEW_EMPLOYEE("Register new employee"),
    FIRE_AN_EMPLOYEE("Fire an employee"),
    SHOW_ALL_EMPLOYEES("Show all employees"),
    CHANGE_SALARY("change salary")
}