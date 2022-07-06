package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList

import logcat.LogPriority
import logcat.logcat

class LinkedList<T> : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    override fun isEmpty(): Boolean = size == 0

    override fun toString(): String = if (isEmpty())
        "Empty List"
    else
        head.toString()

    /* region Adding values to the list */
    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) // Empty List
            tail = head
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }

        tail?.next = Node(value = value)
        tail = tail?.next
        size++

        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++

        return newNode
    }
    /* endregion */

    /* region Removing values from the list */
    fun pop(): T? {
        if (!isEmpty())
            size--

        val result = head?.value
        head = head?.next

        if (isEmpty())
            tail = null

        return result
    }

    fun removeLast(): T? {
        val head = head ?: return null

        if (head.next == null) return pop()

        size--

        var prev = head
        var current = head

        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev

        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        if (node.next == tail)
            tail = node

        if (node.next != null)
            size--

        node.next = node.next?.next
        return result
    }
    /* endregion */

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun contains(element: T): Boolean {
        for (item in this)
            if (item == element)
                return true
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements)
            if (!contains(searched)) return false
        return true
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements)
            append(element)
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = this.iterator()

        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == element)
                return true
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements)
            result = remove(item) || result
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()

        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }
}

fun <T> LinkedList<T>.printReverse() {
    this.nodeAt(0)?.printReverse()
}

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

/* Reverse LinkedList */
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

/* Push
val list = LinkedList<Int>()
list.push(3).push(2).push(1)*/

/* Append
list.append(3).append(2).append(1)
  logcat(LogPriority.INFO) { "Before inserting: $list" }
*/

/* Insert
 var middleNode = list.nodeAt(1)!!
 for (i in 1..3) {
     middleNode = list.insert(-1 * i, middleNode)
 }

 logcat(LogPriority.INFO) { "After inserting: $list" }*/

/* Pop
println("Before popping list: $list")
 val poppedValue = list.pop()
 println("After popping list: $list")
 println("Popped value: $poppedValue")*/

/* Remove Last
 println("Before removing last node: $list")
 val removedValue = list.removeLast()
 println("After removing last node: $list")
 println("Removed value: $removedValue")*/

/* Remove After
println("Before removing at particular index: $list")
val index = 1
val node = list.nodeAt(index - 1)!!
val removedValue = list.removeAfter(node)
println("After removing at index $index: $list")
println("Removed value: $removedValue")*/
