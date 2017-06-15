package important

/**
 *
 * write the description

 * @author songchao
 * *
 * @version [当前项目版本]
 * *
 * @see [相关类/方法]

 * @since [产品/模块版本]
 */

class ConstructDemo(val name: String, var age: Int) {

    var aValue = "just a value"

    companion object {

        final var finalStaticString = "static object"
        var staticString = "static object"
        var staticInt = 1

        fun doStatic(value: String = "value"): Unit {
            println("doStatic value is $value")
        }

        fun printlnStatic(msg: String) {
            println(msg)
        }
    }

    constructor(ii: Int) : this(String(), 1) {

        println("staticString -> $staticString")
        println("this is constructor - Int")
    }

    constructor(ss: String) : this(String(), 1) {

        println("staticString -> $staticString")
        println("this is constructor - String")
    }

    init {
        println("staticInt ->$staticInt")
        println("this is init")
    }
}
