package Merge_Sort

import java.io.File
import java.io.InputStream

class MergeAlgoKt {

    fun merge(a:IntArray,b:Int,m:Int,e:Int): Long {


        val n1 = m - b + 1
        val n2 = e - m
        val leftArr = IntArray(n1)
        val rightArr = IntArray(n2)
        for (i in 0 until n1)
        {
            leftArr[i] = a[b+i]
        }
        for (j in 0 until n2)
        {
            rightArr[j] = a[m+1+j]

        }
        var i = 0
        var j = 0
        var k = b
        var inversions:Long = 0
        while (i<n1 && j<n2)
        {
            if (leftArr[i]<=rightArr[j])
            {
                a[k++] = leftArr[i++]

            }
            else
            {
                a[k++] = rightArr[j++]


                inversions += ((m + 1) - (b + i))
            }



            }

    println("")


        while (i<n1)
        {
            a[k] =leftArr[i]
            i++
            k++
        }
        while (j<n2)
        {
            a[k] =rightArr[j]
            j++
            k++
        }
        println(Math.max(0, inversions))
        return inversions
    }
    fun sort(a:IntArray,b:Int,e:Int):Long
    {
        var inv:Long = 0
        if (b<e)
        {
            val m:Int = (b+e)/2
            inv+=sort(a,b,m)
            //println("1 "+inv)
            inv+=sort(a,m+1,e)
            //println("2 "+inv)
            val v = Math.max(0, merge(a,b,m,e))
            inv = inv + v
            //println("3 "+inv)

        }

        return inv
    }
    fun printArray(s:String,a: IntArray, n: Int) {
        var i: Int
        i = 0
        print("$s\n")
        while (i < n) {
            println(a[i].toString() + " ")
            i++
        }
    }

}

fun main()
{


    val inputStream: InputStream = File("D:\\\\Stanford Algoritms\\\\src\\\\Merge_Sort\\\\intArray.txt").inputStream()
    val lineList = mutableListOf<Int>()

    inputStream.bufferedReader().forEachLine { lineList.add(it.toInt()) }


    val a = lineList.toTypedArray().toIntArray()

    val n = a.size
    val mak = MergeAlgoKt()
    println("before")
    mak.printArray("before",a, n)
    val iv =mak.sort(a, 0, n - 1)
    println("\nafter\n")

    mak.printArray("\nafter",a, n)

    println("\n Total Inversions: "+iv)

}
