package dev.chall.kotlindemo.important

import chall.dev.kotlindemo.InterfaceDemo
import dev.chall.kotlindemo.important.ObjectDemo.AbstractObject
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by chall on 2017/6/21.
 */
@RunWith(JUnit4::class)
class ObjectDemo {
    companion object {
        var var1 = ""
        fun coFun() {

        }
    }

    var onlyObjectOutPublic = object : InterfaceObject {
        var valueInt = -1
    }

    internal var onlyObjectOutInternal = object : InterfaceObject {
        var valueInt = -1
    }

    protected var onlyObjectOutProtected = object : InterfaceObject {
        var valueInt = -1
    }

    private var onlyObjectOutPrivate = object : InterfaceObject {
        var valueInt = -1
    }

    fun getObjectPublic() = object : InterfaceObject {
        var valueInt = -1
    }

    internal fun getObjectInternal() = object : InterfaceObject {
        var valueInt = -1
    }

    protected fun getObjectProtected() = object : InterfaceObject {
        var valueInt = -1
    }

    private fun getObjectPrivate() = object : InterfaceObject {
        var valueInt = -1
    }

    @Test
    fun testObject() {
        //局部变量
        var onlyObjectIn = object {
            var valueString = "text"
            var valueInt = -1

            fun onlyPrintln(): Unit {
                println("打给你看看~")
            }
            //            object TestObjectInObject {
            //                fun doPrintln() {
            //                    println("===testObjectVarInTopClass===")
            //                }
            //            }
        }

        println("valueString is ${onlyObjectIn.valueString}, valueInt is ${onlyObjectIn.valueInt}")
        onlyObjectIn.onlyPrintln()

        //全局变量
        onlyObjectOutPrivate.valueInt
        //        onlyObjectOutProtected.valueInt
        //        onlyObjectOutInternal.valueInt
        //        onlyObjectOutPublic.valueInt

        //方法返回
        getObjectPrivate().valueInt
        //        getObjectProtected().valueInt
        //        getObjectInternal().valueInt
        //        getObjectPublic().valueInt

        //对象变量,不可再方法中定义
        //        object TestObjectVarInMethod {
        //
        //        }
        TestObjectVarInTopFile.doPrintln();
        InterfaceObject.TestObjectInInterfaceInClass.doPrintln();
        AbstractObject.TestObjectInAbstractInClass.doPrintln();
        TestObjectVarInTopFile.doPrintln();
    }

    object TestObjectVarInTopClass {
        fun doPrintln() {
            println("===testObjectVarInTopClass===")
        }
    }


    interface InterfaceObject {
        object TestObjectInInterfaceInClass {
            fun doPrintln() {
                println("===testObjectInInterfaceInClass===")
            }
        }
    }

    abstract class AbstractObject {
        companion object {
            var var1 = ""
            fun coFun() {

            }
        }

        object TestObjectInAbstractInClass {
            fun doPrintln() {
                println("===testObjectInAbstractInClass===")
            }
        }

        open fun aFun() {

        }
    }


    class ExtendCOClass : AbstractObject() {
        //伴随变量是不会被继承重写的
        var var1 = 1

        companion object {
            var var1 = 1
            fun coFun() {

            }
        }

        override fun aFun() {

        }

        fun coFun() {
            AbstractObject.coFun();
            AbstractObject.var1;
        }


    }
}

object TestObjectVarInTopFile {
    fun doPrintln() {
        println("===testObjectVarInTopFile===")
    }

}