package com.shakbari.navigation.pro.utils.stack

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList

fun <Item> List<Item>.toMutableStateStack(
    minSize: Int = 0
): SnapshotStateStack<Item> =
    SnapshotStateStack(this, minSize)

fun <Item> mutableStateStackOf(
    vararg items: Item,
    minSize: Int = 0
): SnapshotStateStack<Item> =
    SnapshotStateStack(*items, minSize = minSize)

@Composable
fun <Item : Any> rememberStateStack(
    vararg items: Item,
    minSize: Int = 0
): SnapshotStateStack<Item> =
    rememberStateStack(items.toList(), minSize)

@Composable
fun <Item : Any> rememberStateStack(
    items: List<Item>,
    minSize: Int = 0
): SnapshotStateStack<Item> =
    rememberSaveable(saver = stackSaver(minSize)) {
        SnapshotStateStack(items, minSize)
    }

private fun <Item : Any> stackSaver(
    minSize: Int
): Saver<SnapshotStateStack<Item>, Any> =
    listSaver(
        save = { stack -> stack.items },
        restore = { items -> SnapshotStateStack(items, minSize) }
    )

class SnapshotStateStack<Item>(
    items: List<Item>,
    minSize: Int = 0
) : Stack<Item> {

    constructor(
        vararg items: Item,
        minSize: Int = 0
    ) : this(
        items = items.toList(),
        minSize = minSize
    )

    init {
        require(minSize >= 0) { "Min size $minSize is less than zero" }
        require(items.size >= minSize) { "Stack size ${items.size} is less than the min size $minSize" }
    }

    @PublishedApi
    internal val stateStack: SnapshotStateList<Item> = items.toMutableStateList()

    public override var lastEvent: StackEvent by mutableStateOf(StackEvent.Idle, neverEqualPolicy())
        private set

    override val items: List<Item> by derivedStateOf {
        stateStack.toList()
    }

    override val lastItemOrNull: Item? by derivedStateOf {
        stateStack.lastOrNull()
    }

    override val lastOrNull: Item? by derivedStateOf {
        lastItemOrNull
    }

    override val size: Int by derivedStateOf {
        stateStack.size
    }

    override val isEmpty: Boolean by derivedStateOf {
        stateStack.isEmpty()
    }

    override val canPop: Boolean by derivedStateOf {
        stateStack.size > minSize
    }

    override infix fun push(item: Item) {
        stateStack += item
        lastEvent = StackEvent.Push
    }

    override infix fun push(items: List<Item>) {
        stateStack += items
        lastEvent = StackEvent.Push
    }

    override infix fun replace(item: Item) {
        if (stateStack.isEmpty()) push(item)
        else stateStack[stateStack.lastIndex] = item
        lastEvent = StackEvent.Replace
    }

    override infix fun replaceAll(item: Item) {
        stateStack.clear()
        stateStack += item
        lastEvent = StackEvent.Replace
    }

    override fun pop(): Boolean =
        if (canPop) {
            stateStack.removeLast()
            lastEvent = StackEvent.Pop
            true
        } else {
            false
        }

    override fun popAll() {
        popUntil { false }
    }

    override infix fun popUntil(predicate: (Item) -> Boolean): Boolean {
        var success = false
        val shouldPop = {
            lastItemOrNull
                ?.let(predicate)
                ?.also { success = it }
                ?.not()
                ?: false
        }

        while (canPop && shouldPop()) {
            stateStack.removeLast()
        }

        lastEvent = StackEvent.Pop

        return success
    }

    override operator fun plusAssign(item: Item) {
        push(item)
    }

    override operator fun plusAssign(items: List<Item>) {
        push(items)
    }

    override fun clearEvent() {
        lastEvent = StackEvent.Idle
    }
}
