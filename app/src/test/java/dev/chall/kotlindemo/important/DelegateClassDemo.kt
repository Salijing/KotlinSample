package dev.chall.kotlindemo.important

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * 首先啥么叫做委托？我麻烦你帮我去做一件事。
 * 有啥用？没啥用，都是把事情完成。
 * 那为啥有？主要目的是解耦
 * Created by chall on 2017/6/26.
 */
@RunWith(JUnit4::class)
class DelegateClassDemo {

    @Test
    fun doDelegateTest() {
        var normal = NormalDelegateImpl(ToDelegateImpl())
//        var normal = object : NormalDelegateImplAbstact(ToDelegateImpl())//OK
        normal.printSomething()
        normal.sayHello()
        normal.doPrintln("大王叫我来巡山！")
//        normal.selfFun()//被委托的类自己的东西他是么有的

        var abs = object : NormalDelegateImplAbstact(ToDelegateImpl()) {
            override fun smile() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        abs.printSomething();
        abs.sayHello()

        var extendAbs = ExtendAbs()
        extendAbs.printSomething();
        extendAbs.sayHello()
        extendAbs.smile()
    }


    interface DelegateInterface {
        fun printSomething()
        fun sayHello()
    }

    interface DelegateInterfaceSecond {
        fun sayHello()
        fun doPrintln(msg: String)
    }

    class ToDelegateImpl : DelegateInterface {
        override fun printSomething() {
            println("printSomething：我是被委托做输出操作的！")
        }

        override fun sayHello() {
            println("ToDelegateImpl-sayHello：我是被委托做输出操作的！")
        }
    }

    class ToDelegateSecondImpl : DelegateInterfaceSecond {
        override fun sayHello() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun doPrintln(msg: String) {
            println("doPrintln(被委托)：$msg")
        }

        fun selfFun(){

        }
    }

    class NormalDelegateImpl(private val toImpl: ToDelegateImpl) : DelegateInterface by toImpl, DelegateInterfaceSecond by ToDelegateSecondImpl() {

        override fun sayHello() {
            toImpl.sayHello()
            println("sayHello：我没有使用委托！")
        }
    }

    class NormalDelegateImpl2() : DelegateInterface by ToDelegateImpl() {

        override fun sayHello() {
            println("sayHello：我没有使用委托！")
        }
    }

    class NormalDelegateImpl3<T>() : DelegateInterface by object : DelegateInterface {

        override fun printSomething() {
            println("printSomething：我是被委托做输出操作的！")
        }

        override fun sayHello() {
            println("sayHello：我是被委托做输出操作的！")
        }
    } {

        override fun sayHello() {
            println("sayHello：我没有使用委托！")
        }
    }

    //抽象
    open abstract class NormalDelegateImplAbstact(toImpl: ToDelegateImpl) : DelegateInterface by toImpl {

        override fun sayHello() {
            println("sayHello：我没有使用委托！")
        }

        abstract fun smile()
    }

    class ExtendAbs() : NormalDelegateImplAbstact(ToDelegateImpl()) {
        override fun smile() {
            println("see -> smile")
        }
    }

    //接口不可使用：Error:(39, 38) Interfaces cannot use delegation
//    interface NormalDelegateImpl : DelegateInterface by ToDelegateImpl{
//
//        override fun sayHello() {
//            println("sayHello：我没有使用委托！")
//        }
//    }
}