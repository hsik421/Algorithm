package com.mobile.app.algorithm

import org.junit.Test
import kotlin.math.abs

class Practice {

    @Test
    fun test1(){
        val A = intArrayOf(17, 28, 43, 67, 88, 92, 100)
        test1Recursive(A,67)
    }
    fun test1Recursive(values : IntArray,target : Int){
        println("test2")
        if(values.size == 1){
            println("values = ${values[0]}")
            return
        }
        var start = 0
        var end = values.size - 1
        var center = values.size.minus(1).div(2)
        if(target >= values[center]){
            test1Recursive(values.sliceArray(center until end),target)
        }else{
            test1Recursive(values.sliceArray(start until center - 1),target)
        }
    }
    @Test
    fun test2(){
        val A = intArrayOf(1,2,3,4,9,25)
        A.forEach {
            var min = 0
            var max: Int = it
            var guess: Int

            while (min <= max) {
                guess = (min + max) / 2
                when {
                    guess * guess == it -> {
                        println(guess)
                        return@forEach
                    }
                    guess * guess > it -> {
                        max = guess - 1
                    }
                    else -> {
                        min = guess + 1
                    }
                }
            }
            println(-1)
        }
    }
    @Test
    fun test3(){
        val A = intArrayOf(1,4,6,8,2,3,5)
        A.forEachIndexed { index, i ->
            A[index]
        }
    }
    @Test
    fun test4(){
        val A = arrayOf(3,3,3,3,1,1,1,2,2,2,2)
        println("group = ${A.groupBy { it }}")
        val map = mutableMapOf<Int,Int>()
        A.forEach {

            map[it] = (map[it]?:0) + 1
        }
        var max = 0
        var result = 0
        map.forEach {
            if(it.value > max){
                max = it.value
                result = it.key
            }
        }
        println("result = ${result}")
    }

    @Test
    fun formingAMagicSquare(){
//        val A = arrayOf(arrayOf(4,8,2),arrayOf(4,5,7),arrayOf(6,1,6))
        val s = arrayOf(arrayOf(7,2,9),arrayOf(6,6,2),arrayOf(5,1,2))

        //4 8 2    4 9 2
        //4 5 7    3 5 7
        //6 1 6    8 1 6

        //7 2 9    7 2 9    6 7 2
        //6 6 2    6 5 4    1 5 9
        //5 1 2    1 8 3    8 3 4

//        1 + 5 + 7 + 7 + 2 + 2 + 3 = 27
        val temp = arrayOf(
            arrayOf(arrayOf(8,1,6),arrayOf(3,5,7),arrayOf(4,9,2)),
            arrayOf(arrayOf(6,1,8),arrayOf(7,5,3),arrayOf(2,9,4)),
            arrayOf(arrayOf(4,9,2),arrayOf(3,5,7),arrayOf(8,1,6)),
            arrayOf(arrayOf(2,9,4),arrayOf(7,5,3),arrayOf(6,1,8)),
            arrayOf(arrayOf(8,3,4),arrayOf(1,5,9),arrayOf(6,7,2)),
            arrayOf(arrayOf(4,3,8),arrayOf(9,5,1),arrayOf(2,7,6)),
            arrayOf(arrayOf(6,7,2),arrayOf(1,5,9),arrayOf(8,3,4)),
            arrayOf(arrayOf(2,7,6),arrayOf(9,5,1),arrayOf(4,3,8))
        )

        val result = arrayListOf<Int>()
        temp.forEach {v1->
            var total = 0
            v1.forEachIndexed { i, values ->
                values.forEachIndexed { j, value ->
                    total += abs(s[i][j] - v1[i][j])
                }
            }
            result.add(total)
        }
        println(result.min())
        result.groupBy { it > 5 }
        //4
    }
    @Test
    fun climbingLeaderboard(){
        val scores = arrayOf(100,100,50,40,40,20,10)
        val alice = arrayOf(5,25,50,120)
        //100,50,40,20,10
        val ranks = scores.distinct()

        val temp = alice.copyOf()
        var i = ranks.size - 1
        alice.forEachIndexed { index, a ->
//            ranks.indices.forEach { r->
//                if(alice[a] < ranks[r]){
//                    temp[a] = r + 2
//                }else if(alice[a] > ranks[0]){
//                    temp[a] = 1
//                }
//            }
            while (i >= 0){
                if(a >= ranks[i]) i = i - 1
                else{
                    temp[index] = i + 2
                    break
                }
            }
            if(i<0) temp[index] = 1
        }


        temp.forEach {
            println(it)
        }



        //6 4 2 1

    }
    @Test
    fun test10(){
        val numbers = arrayOf(3,30,34,5,9)
//        val numbers = arrayOf(6,10,2)
//        val numbers = arrayOf(6,10,2)

        val temp = numbers.copyOf()
        var value = 1000
        println("-----------------------------------")
        numbers.forEach {
            println(it)
        }
        while (value > 1){
            numbers.forEachIndexed { index, i ->
                if(i.div(value) != 0){
                    numbers[index] = i.div(value)
                }else{
                    numbers[index] = i.rem(value)
                }
            }
            value = value.div(10)
        }
//        test11(numbers,1000)
        println("-----------------------------------")
        numbers.forEach {
            println(it)
        }

        (1 until numbers.size).forEach {
            val standard = numbers[it]
            val standard2 = temp[it]
            var aux = it - 1
            while (aux >= 0 && standard > numbers[aux]){
                numbers[aux+1] = numbers[aux]
                temp[aux+1] = temp[aux]
                aux -= 1
            }
            numbers[aux+1] = standard
            temp[aux+1] = standard2
        }
        println("-----------------------------------")
        temp.forEach {
            println(it)
        }
    }
    @Test
    fun test11(){
        var value = 1000
//        val numbers = arrayOf(6,10,2)
        val numbers = arrayOf(3,30,34,5,9)
//        val numbers = arrayOf(67,671,6)
        val temp = numbers.copyOf()
        numbers.forEachIndexed { index, i ->
            (1..4).forEach { _ ->
                if(numbers[index].times(10) < 1000){
                    numbers[index] = numbers[index].times(10) + 9
                }
            }
        }
        numbers.forEach {
            println(it)
        }
        println("---------------------------")
        (1 until numbers.size).forEach {
            val standard = numbers[it]
            val standard2 = temp[it]
            var aux = it - 1
            while (aux >= 0 && standard > numbers[aux]){
                numbers[aux+1] = numbers[aux]
                temp[aux+1] = temp[aux]
                aux -= 1
            }
            numbers[aux+1] = standard
            temp[aux+1] = standard2
        }


        var result = ""
        temp.forEach {
            println(it)
            result += it.toString()

        }
        println(result)
    }
    @Test
    fun test12(){
        val numbers = arrayOf(3,30,34,5,9)

        val temp = numbers.map { it.toString() }

        val a = temp.sortedByDescending {
            it.first().toInt()
        }
        a.forEach {
            println(it)
        }
    }
}