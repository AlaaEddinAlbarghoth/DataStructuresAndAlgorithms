package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList.challanges

import com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList.LinkedList
import com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList.Node

private fun <T> addInReverse(list: LinkedList<T>, node: Node<T>) {
    val next = node.next
    if (next != null)
        addInReverse(list, next)
    list.append(node.value)
}

fun <T> LinkedList<T>.reversed(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null)
        addInReverse(result, head)
    return result
}