package com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.ds.linkedList.LinkedList
import com.alaaeddinalbarghoth.datastructuresandalgorithmsKotlin.presentation.theme.DataStructuresAndAlgorithmsTheme
import logcat.LogPriority
import logcat.logcat

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DataStructuresAndAlgorithmsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    /* List
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

                    /* Regular for loop on our LinkedList via Iterator
                    * println(list)
                    for (item in list) {
                        println("Double: ${item * 2}")
                    }
                    * */

                    val list: MutableCollection<Int> = LinkedList()
                    list.add(3)
                    list.add(2)
                    list.add(1)
                    list.add(4)
                    list.add(5)
                    list.add(5)

                    println(list)
                    list.remove(1)
                    println(list)

                    println(list)
                    list.retainAll(listOf(3, 4, 5))
                    println(list)

                    println(list)
                    list.removeAll(listOf(3, 4, 5))
                    println(list)
                }
            }
        }
    }
}
