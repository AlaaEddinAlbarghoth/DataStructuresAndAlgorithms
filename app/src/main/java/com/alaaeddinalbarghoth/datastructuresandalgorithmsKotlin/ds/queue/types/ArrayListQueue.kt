package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.queue.types

import com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.queue.Queue

class ArrayListQueue<T> : Queue<T> {
    private val list = arrayListOf<T>()

    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? {
        if (list.isEmpty())
            return null
        return list.removeAt(0)
    }

    override val count: Int
        get() = list.size

    override fun peek(): T? = list.getOrNull(0)

    override fun toString(): String =
        list.toString()
}
