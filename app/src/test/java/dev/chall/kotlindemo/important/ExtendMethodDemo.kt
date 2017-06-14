package chall.dev.kotlindemo

import important.ConstructDemo
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExtendMethodDemo {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        var extend1 = ConstructDemo(1)
        println("before -> " + extend1.aValue)
        extend1.aValue = "doChange"
        println("after -> "+extend1.aValue)
    }
}








