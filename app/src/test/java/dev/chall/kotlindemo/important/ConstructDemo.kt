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

class ConstructDemo(val name: String, var age: Int = 0, doSomething: () -> Unit) {

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

    constructor(ii: Int) : this(String(), 1, ::sayHello) {

        println("staticString -> $staticString")
        println("this is constructor - Int")
    }

    constructor(bb: Boolean = false) : this(String(), 1, ::sayHello) {

        println("staticString -> $staticString")
        println("this is constructor - Boolean")
    }

    constructor(ss: String) : this(String(), 1, ::sayHello) {

        println("staticString -> $staticString")
        println("this is constructor - String")
    }

    init {
        println("staticInt ->$staticInt")
        println("this is init")
    }
}

private class ConstructDemoOther {

    constructor(bb: Boolean = false) {
        println("this is constructor - Boolean")
    }

    constructor(ss: Float = 1f) {
        println("this is constructor - String")
    }

    constructor(i: Int, bb: Boolean = false) {
        println("this is constructor - Boolean")
    }

    constructor(i: Int, ss: Float = 1f) {
        println("this is constructor - String")
    }
}

fun sayHello() {
    var const1 = ConstructDemo("", 1, ::sayHello)
    var const2 = ConstructDemo(1)
    var const3 = ConstructDemo()
    var const4 = ConstructDemo("")

//    var const5 = ConstructDemoOther(1)
}
