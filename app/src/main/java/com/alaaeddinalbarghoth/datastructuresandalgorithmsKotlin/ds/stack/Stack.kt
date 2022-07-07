package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.stack


interface Stack<T> {

    fun pop(): T?

    fun push(element: T)

    fun peek(): T?

    val count: Int

    val isEmpty: Boolean
        get() = count == 0
}