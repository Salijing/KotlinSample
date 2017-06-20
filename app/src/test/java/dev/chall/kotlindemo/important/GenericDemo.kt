package chall.dev.kotlindemo

import important.ConstructDemo
import org.junit.Test
import java.io.File

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class GenericDemo {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        Generic<String>().test("12345671")
//        Generic<Array<String>>().test(arrayOf("a", "b"))
        printlnInfo<String>("hahha")

//        var arrayList1: ArrayList<Int> = arrayListOf(1, 2, 3)
//        var arrayList2: ArrayList<out Any> = arrayList1
//        testInOut();

        var from = arrayOfNulls<Any>(5)
        var to = arrayOf("a", "b")
        copy(from, to)
        println("from: 0->${from[0]} ;1-> ${from[1]}")

        var teses: List<*> = listOf("a", 1, 1.0f)
        println(teses[0])
        println(teses[1])
        println(teses[2])
        var teses1: List<*> = teses
    }

    class Generic<T : String>() {
        fun test(s: T) {
            println("show info " + s.toString())
        }
    }

    class GenericWhere<T>()
    where T : Cloneable, T : Comparable<*> {
        fun test(s: T) {
            println("show info " + s.toString())
        }
    }

    fun <T : String> printlnInfo(value: T) {
        println("value is $value")
    }

    fun <T> printlnInfo2(value: T)
            where T : Cloneable, T : Comparable<*> {
        println("value is $value")
    }

    /* ============声明=====================
                父类
             out↑↓只可作为入参
    只可作为出参↑↓in
                 子类
     */
    fun testInOut(testOut: AbstractOut<String>, testIn: AbstractIn<Any>) {
        var doOut: AbstractOut<Any> = testOut
        var doIn: AbstractIn<String> = testIn
    }

    fun testInOutStar(testOut: AbstractOut<String>, testIn: AbstractIn<Any>) {
        var doOut: AbstractOut<*> = testOut//var doOut:AbstractOut<String> = testOut
        var doIn: AbstractIn<*> = testIn//var doIn: AbstractOut<String> = testIn
    }

    abstract class AbstractOut<out T> {
        //只可作为出参
        abstract fun returnT(): T
        //Type parameter T is declared as 'out' but occurs in 'in' position in type T
        //abstract fun returnT(value: T)
    }

    abstract class AbstractIn<in T> {
        //只可作为入参
        abstract fun inputT(value: T)
        //Type parameter T is declared as 'in' but occurs in 'out' position in type T
        //abstract fun returnT(): T
    }

    /* ============使用=====================
                父类
             out↑↓只可作为入参
    只可作为出参↑↓in
                 子类
     */
    fun copy(from: Array<Any?>, to: Array<out Any>) {
        for (i in 0 until Math.min(from.size, to.size)) {
            from[i] = to[i]
        }
    }
}