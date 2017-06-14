package chall.dev.kotlindemo

import important.ConstructDemo
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class InlineDemo {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        println("sum resuslt is ${sum(1, 2)}")
        sub(1, 2,::subReal)
        println("sum resuslt is ${}")
    }

    inline fun sum(a: Int, b: Int): Int {
        return a + b
    }

    inline fun sub(a: Int, b: Int, doSub: (a1: Int, b1: Int) -> Int): Int {
        return doSub(a, b)
    }

    fun subReal(a: Int, b: Int): Int {
        return a - b
    }
}








