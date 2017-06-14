package chall.dev.kotlindemo

import important.ConstructDemo
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {

        var haha = ConstructDemo(1)

        var int1: Int = 1
        var float1: Float = int1.toFloat()

        var int2: Int = 2_1_4_1
        println("int2 is $int2")

        var char1: Char = 'c'
        println("char1 is $char1.toInt is ${char1.toInt()}")

        var boolean1: Boolean = true

        var array1: Array<String> = arrayOf<String>("0", "1", "2")
        println("array1 is ${"" + array1.size + " " + array1[0]}")

        var array2: Array<Int?> = arrayOfNulls<Int>(5)
        println("array2-0 is ${array2[0]}")
        var array3: Array<String> = Array(5, { i -> (i * 5).toString() })
        println("array3-0 is ${array3[1]}")

        var string1: String = "string1"
        println("string1 is $string1")
        var string2 = String()
        println("string1 is ${string2},length is ${string2.length}")
        var value = string1[0]
        println("string1-0 is $value ")
        var string3 = """
  haha\n\r\n\r
      haha
"""
        println(string3.trimMargin("h"))
        var string4 = """
输出 ${"$"}
"""
        println(string4)

        var intWhen1 = 1
        var intWhen2 = 1
        when (intWhen1 + intWhen2) {
            1 -> println("when-result : 1")
            2 -> println("when-result : 2")
            in 1..10 -> println("when-result : 1..10")
            is Int -> println("when-result : is Int")
            intWhen1 * intWhen2 -> print("when-result : other")
            else -> print("when-result : else")
        }

        var in1 = 1;
        if (in1 in 1..10)
            println("in1 is $in1")

        var in2 = "abcdefg"
        print("item is ")
        for (inItem in in2) {
            print("$inItem ;")
        }

        var fucusClass = FocusClass()
//        useMethod<FocusClass>()
    }

    fun <T>useMethod(itm:T) {

    }

    class FocusClass {

    }
}








