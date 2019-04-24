package com.mobile.app.algorithm

import org.junit.Test
import kotlin.math.abs

class Codility {
    /* cyclicRotation
    An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

    The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

    Write a function:

    fun solution(A: IntArray, K: Int): IntArray

    that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

    For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
    the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
    For another example, given

    A = [0, 0, 0]
    K = 1
    the function should return [0, 0, 0]

    Given

    A = [1, 2, 3, 4]
    K = 4
    the function should return [1, 2, 3, 4]

    Assume that:

    N and K are integers within the range [0..100];
    each element of array A is an integer within the range [−1,000..1,000].
    In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

    */
    @Test
    fun cyclicRotation(){
        val A = intArrayOf()
        val K = 10

        val temp = A.copyOf()
        var num = 0
        if(A.isNotEmpty()) num = K % A.size
        A.forEachIndexed { index, i ->
            if(index + num < A.size){
                temp[index+num] = i
            }else{
                temp[index+num-A.size] = i
            }
        }
        print(temp)
    }
    /* dddOccurrencesInArray
        A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

        For example, in array A such that:

          A[0] = 9  A[1] = 3  A[2] = 9
          A[3] = 3  A[4] = 9  A[5] = 7
          A[6] = 9
        the elements at indexes 0 and 2 have value 9,
        the elements at indexes 1 and 3 have value 3,
        the elements at indexes 4 and 6 have value 9,
        the element at index 5 has value 7 and is unpaired.
        Write a function:

        fun solution(A: IntArray): Int

        that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

        For example, given array A such that:

          A[0] = 9  A[1] = 3  A[2] = 9
          A[3] = 3  A[4] = 9  A[5] = 7
          A[6] = 9
        the function should return 7, as explained in the example above.

        Write an efficient algorithm for the following assumptions:

        N is an odd integer within the range [1..1,000,000];
        each element of array A is an integer within the range [1..1,000,000,000];
        all but one of the values in A occur an even number of times.
     */
    @Test
    fun oddOccurrencesInArray(){
        val A = arrayOf(1,2,3,4,5,6,1,2,3,4,5)
        var result = 0
        A.forEach { i ->
            result = i.xor(result)
        }
        println(result)
    }
    /*
        A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

        Count the minimal number of jumps that the small frog must perform to reach its target.

        Write a function:

        class Solution { public int solution(int X, int Y, int D); }

        that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

        For example, given:

          X = 10
          Y = 85
          D = 30
        the function should return 3, because the frog will be positioned as follows:

        after the first jump, at position 10 + 30 = 40
        after the second jump, at position 10 + 30 + 30 = 70
        after the third jump, at position 10 + 30 + 30 + 30 = 100
        Write an efficient algorithm for the following assumptions:

        X, Y and D are integers within the range [1..1,000,000,000];
        X ≤ Y.
    */

    @Test
    fun frogJummp(){
        val x = 10
        val y = 85
        val d = 30
        var result = y - x
        result = if(result % d == 0)result / d else result / d + 1
        print(result)
    }

    @Test
    fun permMissingElem(){
        val a = arrayOf(1,2,3,5,6)
        var sum = 0
        (0..a.size + 1).forEach { sum += it }
        a.forEach { sum -= it }
        print(sum)
    }
    @Test
    fun tapeEquilibrium(){
        val A = arrayOf(3,1,2,4,3)

        var result = 0
        var total = 0
        var sum = 0
        A.forEach { total += it }
        (1 until A.size).forEach { index ->
            sum += A[index - 1]
            if(index == 1){
                result = abs(sum - (total - sum))
            }else{
                if(result > abs(sum - (total - sum))){
                    result = abs(sum - (total - sum))
                }
            }
        }
        println("result = $result")
    }
    @Test
    fun permCheck(){
        val A = arrayOf(9, 5, 7, 3, 2, 7, 3, 1, 10, 8)
        var result = 1
        A.sort()
        (1 until A.size + 1).forEach {
            if(it != A[it - 1]){
                result = 0
            }
        }
        println(result)
    }
    @Test
    fun frugRiverOne(){
        val A = arrayOf(1,3,1,3,2,1,3)
        val X = 3
        var result = -1
        val map = hashMapOf<Int,Int>()
        A.forEachIndexed { index, i ->
            if(i <= X && map[i] == null){
                map[i] = index
            }
            if(map.size == X){
                result = map.values.max()?:-1
            }
        }
        println(result)
    }
}