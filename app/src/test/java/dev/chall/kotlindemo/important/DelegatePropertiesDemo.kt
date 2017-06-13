package chall.dev.kotlindemo

import org.jetbrains.anko.doAsync
import org.junit.Test
import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class DelegatePropertiesDemo {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        //************************************lazy*******************************************
        //必须是val
        val testLazy: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            println("this is TestLazy")
            Thread.sleep(500)
            "haha"
        }
        doAsync {
            println("testLazy1 is $testLazy")
        }
        doAsync {
            println("testLazy2 is $testLazy")
        }
        doAsync {
            println("testLazy3 is $testLazy")
        }
        //println("testLazy4 is $testLazy")

        //************************************observable*******************************************
        var name: String by Delegates.observable("初始化") {
            prop, old, new ->
            println("$old -> $new")
        }

        println(name)
        name = "赋值"
        println(name)

        //************************************vetoable*******************************************
        var nameVetoable: String by Delegates.vetoable("初始化") {
            prop, old, new ->
            println("new is $new ;old is $old")
            true//false 赋值失败，true 赋值成功
        }
        println("nameVetoable is ${nameVetoable}")
        nameVetoable = "赋值"
        println("nameVetoable2 is ${nameVetoable}")

        //************************************notNull********************************************
        var testNotNull by Delegates.notNull<String>()
//        println("testNotNull is $testNotNull")//java.lang.IllegalStateException: Property testNotNull should be initialized before get.
        testNotNull = "init"
        println("testNotNull is $testNotNull")

        //***************************************Map*********************************************
        var useMap = UseMap(mapOf("a" to "is-a", "b" to 2))
        println("a is ${useMap.a}; b is ${useMap.b}")

        //*******************************自定义委托属性 ReadWriteProperty***************************
        var testDelegate: String by Delegate()
        println("testDelegate is $testDelegate")
        testDelegate = "赋值"
        println("testDelegate2 is $testDelegate")

        //*******************************自定义属性 ReadOnlyProperty*******************************
        val testReadOnlyProperty: String by ReadOnlyDelegate("给TestOnlyReadProperty复制")
        println("testReadOnlyProperty is ${testReadOnlyProperty}")

        Thread.sleep(2000)
    }

    private class Delegate : ReadWriteProperty<Any?, String> {

        var delegateValue: String by Delegates.observable("") {
            property, oldValue, newValue ->
            println("old value is $oldValue; new value is $newValue ")
        }

        override fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return delegateValue
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            delegateValue = value
        }

    }

    private class ReadOnlyDelegate : ReadOnlyProperty<Any?, String> {

        val mValue: String

        constructor(value: String) {
            mValue = value
        }

        override fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return mValue
        }

    }

    private class UseMap(map: Map<String, Any?>) {
        val a: String by map
        val b: Int by map
    }
}

