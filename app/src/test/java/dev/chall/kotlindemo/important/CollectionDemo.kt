package chall.dev.kotlindemo

import android.os.Build
import android.support.annotation.RequiresApi
import important.ConstructDemo
import org.junit.Test
import java.util.*
import java.util.Map

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class CollectionDemo {
    @RequiresApi(Build.VERSION_CODES.N)
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        var map = HashMap<String, Int>()
        map["1"] = 1
        println("hasmap[1] is ${map["1"]}")
        map["B"] = 2
        println("hasmap[2] is ${map.get("2")}")
        println("hasmap[12] is ${map.get("12")}")
        for (entry in map) {
            println("for: key is ${entry.key}; value is ${entry.value}; is Map.Entry？ ${entry is Map.Entry<*, *>}")
        }
        map.forEach { t, u -> println("forEach: key is " + t + "; value is " + u) }

        var testMap = mapOf<String, Int>("a" to 1, Pair("key", 1))
        println("a is ${testMap.get("a")}+${testMap is LinkedHashMap}")

        var testMutableMap = mutableMapOf<String, Int>("a" to 1, Pair("b", 2))
        println("a is ${testMutableMap["a"]}")
        testMutableMap.remove("a")
        println("a is ${testMutableMap["a"]}")
        testMutableMap["a"] = 121
        println("a is ${testMutableMap["a"]}")

        var writeList = ArrayList<String>()
        writeList.add("A")
        writeList.add("B")
        writeList.add("C")
        for (value in writeList) {
            println("for: writeList value is " + value)
        }
        writeList.forEachIndexed { index, s ->
            println("forEachIndexed: writeList value is " + s + "; index is " + index)
        }

        writeList = arrayListOf()
        writeList.add("Q")

        var writeLinkedList: LinkedList<String> =LinkedList<String>()
        writeLinkedList.add("LinkedL0")
        println("writeLinkedList[0] is "+writeLinkedList[0])

        writeList = mutableListOf<String>() as ArrayList<String>
        writeList.add("W")

        var testList = listOf(1, 2, 3, 4, 5, -10)
        println("testList has = 5 -> ${testList.any { it == 5 }}")
        println("testList has = 6 -> ${testList.any { it == 6 }}")
        println("testList is is-all-Int count -> ${testList.all { it is Int }}")
        println("testList is is-Int count -> ${testList.count { it is Int }}")
        println(testList.foldRight(0) { i: Int, i1: Int ->
            println("foldRight: i is ${i},i1 is ${i1}")
            i - i1
        })
        testList.forEach { println("testList.forEach value is $it") }
        testList.forEachIndexed { index, i -> println("testList.forEachIndexed: index is ${index}, value is $i") }
        println("Max in testList is ${testList.max()}")
        println("MaxByMethid in testList is ${testList.maxBy() { -it }}")
        println("Min in testList is ${testList.min()}")
        println("MinBy in testList is ${testList.minBy() { -it }}")
        println("noneFollowMethod in testList is ${testList.none() { it / testList.size == 1 }}")
        println("Reduce in testList is ${testList.reduce { acc, i ->
            println("reduce: acc is $acc,i is $i")
            acc + i
        }}")
        println("ReduceRight in testList is ${testList.reduceRight { i, acc ->
            println("ReduceRight: acc is $acc,i is $i")
            acc + i
        }}")
        println("sumByFun in testList is ${testList.sumBy { it * 2 }}")
        println("dropFrontElement in testList is ${testList.drop(3)}")
        println("dropLastElement in testList is ${testList.dropLast(3)}")
        println("dropElement start front by condition-while in testList is ${testList.dropWhile() {
            println("dropElementWhile: it is $it")
            it <= 2
        }
        }")
        println("dropElement start end by condition-while in testList is ${testList.dropLastWhile() {
            println("dropElementWhileLast: it is $it")
            it <= 2
        }
        }")

        println("ListFilter is ${testList.filter { it < 3 }}")
        println("ListFilter is ${testList.first() { it > 3 }}")
        println("ListSlice is ${testList.slice(listOf(4))}")
        println("List.Take is ${testList.take(2)}")
        println("List.TakeLast is ${testList.takeLast(2)}")
        println("List.TakeWihle is ${testList.takeWhile { it < 3 }}")
        println("List.TakeWihleLast is ${testList.takeLastWhile { it < 3 }}")
        println("flatMap is ${testList.flatMap { listOf(it * 0, it * 1, it * 2) }}")//listof对list遍历，通过其中的表达式（逗号分隔），形成其中元素
        println("groupBy-1 is ${testList.groupBy { if (it < 3) "a" else "b" }}")//通过指定或者判断表达式，把属于统一条件的取为同一key的map。最终形成一个map的list
        println("groupBy-2 is ${testList.groupBy { "a" }}")
        println("mapIndexed is ${testList.mapIndexed { index, i ->
            println("index is $index , i is $i")
            "$index:$i"
        }}")
        println("elementAt 1 is ${testList.elementAt(1)}")
        println("elementAtOrNull 10 is ${testList.elementAtOrNull(10)}")
        println("elementAtOrElse 10 is ${testList.elementAtOrElse(10, { it * -1 })}")//it代表前面的index（这里其他的表达式也是OK的比如{null}）
        println("single:index -> 5 is ${testList.single() { it == 5 }}")
        var singleList = listOf<String>("a")
        println("singleOnly is ${singleList.single()}")
//        println("single:index -> 10 is ${testList.single() { it == 10 }}")
        println("singleOrNull:index -> 10 is ${testList.singleOrNull() { it == 10 }}")

        println("partition-list is ${testList.partition() { it % 2 == 0 }}")//.first/.second 可获取具体list

        var testList2 = listOf(2, 1)
        println("list-plus : ${testList + (testList2)}")
        println("list-plus : ${testList.plus(testList2)}")
        println("list-zip : ${testList.zip(testList2)}")//[(1, 2), (2, 1)]
        println("list-zip : ${testList.zip(testList2).unzip()}")//([1, 2], [2, 1])

        println("list-reversed :${testList.reversed()}")
        println("list-sort :${testList.sorted()}")
        println("list-sortBy :${testList.sortedBy() { it * -1 }}")
        println("list-sortedDescending :${testList.sortedDescending()}")

        var testSet = mutableSetOf<String>("A","B")
        testSet.add("C")
        println("testSet -> ${testSet.remove("A")}+${testSet.size}")
        println("testSet ->+${testSet}")


        var aaa = ConstructDemo(1)
        println(aaa.age)
        var ss: String? = null
        println((ss?.length ?: println("hahahha")))

        var stringList = listOf("aa11231231", "aw2")//按照顺序，依据首字母的值进行判断
        println("max is ${stringList.max()}")

    }
}

