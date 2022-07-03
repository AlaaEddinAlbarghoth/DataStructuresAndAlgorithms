package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String = if (next != null)
        "$value -> ${next.toString()}"
    else
        "$value"
}