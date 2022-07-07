package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.stack

import com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList.LinkedList

fun <T> LinkedList<T>.printInReverse() {
    val stack = StackImpl<T>()
    for (item in this)
        stack.push(item)

    var node = stack.pop()
    while (node != null) {
        print(node)
        node = stack.pop()
        if (node != null)
            print(" -> ")
    }
}