package chall.dev.kotlindemo

import important.ConstructDemo
import org.junit.Test
import kotlin.reflect.full.createInstance

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ReflectDemo() {

    var reflectVariable1 = 1

    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {

        var testReflect = ConstructDemo::class
        println("testReflect-> simpleName:${testReflect.simpleName}")
        println("testReflect-> constructors:${testReflect.constructors}")

        var cons = InnerAndReflectDemo::class
        var consConstructors = cons.constructors as ArrayList;
        var consObject = consConstructors[0].call(1)
        println("test123 is " + consObject.test123)
        consObject.resetIndex(12)
//::InnerAndReflectDemo返回的是构造函数
//        println("test123 is " + ::InnerAndReflectDemo.invoke(null).test123)

        println(consObject::test123)
        var consMethod = consObject::resetIndex
        consMethod.call(2)

        var exam = ReflectDemo::class
        var init = exam.createInstance()
        println("isOld -> " + init.isOld(12))

        //构造函数引用
        doCons(::ReflectDemo)

        println("reflectVariable is " + ::reflectVariable)


        var testInnerAndReflectDemo = InnerAndReflectDemo(1)
        //将对象的函数绑定到变量作为引用
        var demoFun = testInnerAndReflectDemo::resetIndex
        demoFun(1222)

        //将对象的属性/变量绑定到变量作为引用
        var demoVariable = testInnerAndReflectDemo::test123
        println(demoVariable.get())

        var values = "12345"
        var testVari = values::length
        println("$values length is ${testVari.get()}")

    }

    fun isOld(age: Int): Boolean = age > 20

    fun doCons(factory1: () -> ReflectDemo) {

    }
}

var reflectVariable = 1
