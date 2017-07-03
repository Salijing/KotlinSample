package chall.dev.kotlindemo

import important.ConstructDemo
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 * THX to https://stackoverflow.com/questions/33616464/function-references-and-lambdas
 * KotlinSample\files\Q1.png
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class InlineDemo {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        println("sum resuslt is ${sum(1, 2)}")

        println("sum resuslt is ${sub(1, 2, ::subReal/*顶层引入*/)}")

        this doPrint "hahah"
    }

    infix fun doPrint(msg:String){
        println(msg)
    }
}

inline fun sum(a: Int, b: Int): Int {
    return a + b
}

inline fun sub(a: Int, b: Int, noinline doSub: (a1: Int, b1: Int) -> Int): Int {
    return doSub(a, b)
}

fun subReal(a: Int, b: Int): Int {
    return a - b
}






