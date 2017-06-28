package chall.dev.kotlindemo

import chall.dev.kotlindemo.InterfaceDemo.Companion.variable3
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * <p>write the description
 * @author songchao
 * @version [当前项目版本]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

interface InterfaceDemo {

    companion object {
        var variable2 = 2
        val variable3 = "AAA"
    }

    var variable1: Int

    fun execute()

    //可以拥有具体实现
    fun execute(type: Int) {
        println("is InterfaceDemo-execute，variable1 is "+variable1)
    }
}

class ImplInterface(override var variable1: Int) : InterfaceDemo {

    override fun execute() {
        InterfaceDemo.variable2 = 3
//        InterfaceDemo.variable3 =""
    }
}

class ImplInterface1() : InterfaceDemo {
    override var variable1: Int=1

    override fun execute() {
    }
}

interface InterfaceMore {

    var variable1: Int
    var variable2: Int

    //可以拥有具体实现
    fun execute(type: Int) {
        println("is InterfaceMore-execute ，variable1 is" + variable1 + "，variable2 is" + variable2)
    }
}

@RunWith(JUnit4::class)
class TestMoreImpl {

    @Test
    fun doTest() {
        MoreImpl(1, -1).execute(101)

        var impl1 = ImplInterface1()
        println(impl1.variable1)
    }

    class MoreImpl(override var variable1: Int, override var variable2: Int) : InterfaceDemo, InterfaceMore {
        override fun execute(type: Int) {
            super<InterfaceDemo>.execute(type)
            super<InterfaceMore>.execute(type)
        }

        override fun execute() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}