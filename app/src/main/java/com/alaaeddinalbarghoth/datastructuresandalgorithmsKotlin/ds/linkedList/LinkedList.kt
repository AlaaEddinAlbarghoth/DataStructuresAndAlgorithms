package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList

class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    private fun isEmpty(): Boolean = size == 0

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