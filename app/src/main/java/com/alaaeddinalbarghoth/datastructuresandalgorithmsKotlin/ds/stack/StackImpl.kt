package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.stack

class StackImpl<T> : Stack<T> {
    private val storage = arrayListOf<T>()

    companion object {
        fun <T> create(items: List<T>): Stack<T> {
            val stack = StackImpl<T>()
            for (item in items)
                stack.push(item)
            return stack
        }
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (isEmpty)
            return null
        return storage.removeAt(storage.size - 1)
    }

    override fun peek(): T? = storage.lastOrNull()

    override val count: Int
        get() = storage.size

    override fun toString() = buildString {
        appendLine("---top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("----------")
    }
}

fun <T> stackOf(vararg elements: T): Stack<T> {
    return StackImpl.create<T>(elements.asList())
}