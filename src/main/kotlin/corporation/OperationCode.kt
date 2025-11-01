package corporation

enum class OperationCode(val title: String, ) {
    EXIT(title = "Exit"),
    REGISTER_NEW_ITEM(title = "Register new item"),
    SHOW_ALL_ITEMS("show all items"),
    REMOVE_PRODUCT_CARD("Remove product card")
}