package chall.dev.kotlindemo

import important.ConstructDemo
import org.junit.Test
import java.io.File

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class SealedDemo2 {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        var first = First()
        println(sealed(first))
    }

    fun sealed(orig: Original): String {
        when (orig) {
            is First -> return "First"
            is Second -> return "Second"
            is Third -> return "Third"
        }
        return "null"
    }

//    class hahha : Original(){
//
//    }
}