package important

/**
 * Created by chall on 2017/6/12.
 */

data class DataClassDemo(val int1: Int = 1, val int2: Int, val string1: String) {
    //使用实例
    fun addition_isCorrect() {
        var cons = DataClassDemo(1, 10, "A")
        var cons1 = cons.copy(int1 = 2)
        println(cons1.string1)
        val (int1, int2, String1) = cons1
        println(int1)
    }
}
