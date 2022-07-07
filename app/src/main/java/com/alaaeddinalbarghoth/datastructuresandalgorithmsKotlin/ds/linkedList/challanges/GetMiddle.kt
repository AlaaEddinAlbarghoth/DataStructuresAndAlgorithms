package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList.challanges

import com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList.LinkedList
import com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList.Node

/* Runner technique */
fun <T> LinkedList<T>.getMiddle(): Node<T>? {
    var fast = this.nodeAt(0)
    var slow = this.nodeAt(0)

    while (fast != null) {
        fast = fast.next

        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }

    return slow
}