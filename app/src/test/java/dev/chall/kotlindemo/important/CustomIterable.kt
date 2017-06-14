package chall.dev.kotlindemo

import important.ConstructDemo
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class CustomIterable {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        var customIterable = CustomIterable()
        for (value in customIterable) {
            println("current value is $value")
        }
        println("巡结束了")
    }


    class CustomIterable : Iterable<String> {
        operator override fun iterator(): Iterator<String> {
            return CustomIterator()
        }
    }
    class CustomIterator : Iterator<String> {
        var isOk = true
        /**
         * 最终返回决定是否执行next()
         */
        operator override fun hasNext(): Boolean {
            println("in hasNext()")
            if (isOk) {
                isOk = false;
                return true
            }
            return isOk
        }

        operator override fun next(): String {
            println("in next()")
            return "大王叫我来巡山~"

        }
    }
}

