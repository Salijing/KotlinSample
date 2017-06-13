package chall.dev.kotlindemo

import important.ConstructDemo
import org.junit.Test
import kotlin.reflect.full.createInstance

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ReflectDemo {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {

        var testReflect = ConstructDemo::class
        println("testReflect-> simpleName:${testReflect.simpleName} ; ${testReflect.constructors}")

        println(::InnerAndReflectDemo.invoke(null).test123)

        var cons = InnerAndReflectDemo::class
        var consConstructors = cons.constructors as ArrayList;
        var consObject = consConstructors[0].call(null)
        println(consObject.test123)
        println(consObject::test123)
        var consMethod = consObject::resetIndex
        consMethod.call(2)

        var exam = ReflectDemo::class
        var init = exam.createInstance()
        println(init.isOld(12))

    }

    fun isOld(age: Int): Boolean = age > 20
}

