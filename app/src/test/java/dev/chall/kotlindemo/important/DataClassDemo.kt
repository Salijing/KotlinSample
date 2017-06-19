package important

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by chall on 2017/6/12.
 */
@RunWith(JUnit4::class)
class DataClassDemo() {
    //使用实例
    @Test
    fun addition_isCorrect() {
        var cons = DataClassSample(1, 10, "A")
        println("cons int1 is ${cons.int1}")
        cons.int1 = 2
        println("cons int1 is ${cons.int1}")
        println("cons string1 is ${cons.string1}")
        var cons1 = cons.copy()
        println("cons1 copy1-string1 is ${cons1.string1}")
        var cons2 = cons.copy(string1 = "B")
        println("cons2 copy2-string1 is ${cons2.string1}")
        val (int1, _, string1: String) = cons
        println("values is $int1  ,$string1")

        var mPair = Pair<String, Int>("first", 101)
        println("mPair is ${mPair.first},${mPair.second}")
        var mTriple = Triple<String, Boolean, Double>("first", false, 2.0)
        println("mTriple is ${mTriple.first},${mTriple.second},${mTriple.third}")
    }
}

@RunWith(JUnit4::class)
data class DataClassSample(var int1: Int = 1, val int2: Int, val string1: String) {
}
