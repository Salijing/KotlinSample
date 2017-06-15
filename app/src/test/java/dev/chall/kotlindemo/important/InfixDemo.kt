package chall.dev.kotlindemo

import important.ConstructDemo
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 * THX to https://stackoverflow.com/questions/33616464/function-references-and-lambdas
 * KotlinSample\files\Q1.png
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class InfixDemo {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        this doPrint "hahah"
        println("int(1)-plus1(2) -> ${1 plus1 2}")
    }

    infix fun doPrint(msg: String) {
        println(msg)
    }

    infix fun Int.plus1(value: Int): Int {
        return this + value + 1
    }
}







