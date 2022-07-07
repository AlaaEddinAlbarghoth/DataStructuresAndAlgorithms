package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.stack.challanges

import com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.stack.StackImpl

fun String.checkParentheses(): Boolean {
    val stack = StackImpl<Char>()

    for (character in this)
        when (character) {
            '(' -> stack.push(character)
            ')' -> if (stack.isEmpty)
                return false
            else
                stack.pop()
        }
    return stack.isEmpty
}
