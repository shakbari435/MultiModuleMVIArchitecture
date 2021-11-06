package com.shakbari.navigation.pro.utils.stack

inline fun <reified I : Item, Item> Stack<Item>.popUntil(): Boolean =
    popUntil { item -> item is I }

enum class StackEvent {
    Push,
    Replace,
    Pop,
    Idle
}

interface Stack<Item> {

    val items: List<Item>

    val lastEvent: StackEvent

    val lastItemOrNull: Item?

    @Deprecated(
        message = "Use 'lastItemOrNull' instead. Will be removed in 1.0.0.",
        replaceWith = ReplaceWith("lastItemOrNull")
    )
    val lastOrNull: Item?

    val size: Int

    val isEmpty: Boolean

    val canPop: Boolean

    infix fun push(item: Item)

    infix fun push(items: List<Item>)

    infix fun replace(item: Item)

    infix fun replaceAll(item: Item)

    fun pop(): Boolean

    fun popAll()

    infix fun popUntil(predicate: (Item) -> Boolean): Boolean

    operator fun plusAssign(item: Item)

    operator fun plusAssign(items: List<Item>)

    fun clearEvent()
}
