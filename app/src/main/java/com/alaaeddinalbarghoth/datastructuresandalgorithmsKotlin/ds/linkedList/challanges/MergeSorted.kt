package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList.challanges

import com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList.LinkedList
import com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList.Node

/* region MergeSorted */
fun <T : Comparable<T>> LinkedList<T>.mergeSorted(otherList: LinkedList<T>): LinkedList<T> {
    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this

    val result = LinkedList<T>()

    var left = nodeAt(0)
    var right = otherList.nodeAt(0)

    while (left != null && right != null) {
        if (left.value < right.value) {
            left = append(result, left)
        } else {
            right = append(result, right)
        }
    }

    while (left != null) {
        left = append(result, left)
    }
    while (right != null) {
        right = append(result, right)
    }

    return result
}

fun <T : Comparable<T>> append(result: LinkedList<T>, node: Node<T>): Node<T>? {
    result.append(node.value)
    return node.next
}
/* endregion */