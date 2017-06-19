package chall.dev.kotlindemo

import important.ConstructDemo
import org.junit.Test
import java.io.File

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class SealedDemo {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        sealed(First())
    }

    fun sealed(orig: Original) {
        when (orig) {
            is First -> println("is First")
            is Third -> println("is Third")
        }
    }
}

sealed class Original {

    open var flag = 1

    open fun A() {}
}

//子类必须和Original类在同一个文件
class First : Original() {
    override fun A() {}
}

class Second : Original() {
    override var flag: Int = 2
}

class Third(flagTemp: Int) : Original() {
    override var flag: Int = 2

    init {
        flag = flagTemp
    }
}