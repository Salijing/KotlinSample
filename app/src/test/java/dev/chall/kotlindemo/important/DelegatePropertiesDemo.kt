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
    fun addition_isCorrect() {
        //************************************lazy*******************************************
        //必须是val
        val testLazy: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
            println("this is TestLazy")
            Thread.sleep(500)
            "haha"
        }
        doAsync {
            //休息会，让别人调完我在调，就不用初始化了，因为已经初始化过了，哈哈哈
            Thread.sleep(1000)
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
            println("old is  $old -> new is $new")
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
        println("useMap: a is ${useMap.a}; b is ${useMap.b}")
        var useMutableMap = UseMutableMap(mutableMapOf("a" to "is-a", "b" to 2))
        println("useMutableMap: a is ${useMutableMap.a}; b is ${useMutableMap.b}")

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

    private class Delegate : ReadWriteProperty<String?, String> {

        var delegateValue: String by Delegates.observable("") {
            property, oldValue, newValue ->
            println("old value is $oldValue; new value is $newValue ")
        }

        override fun getValue(thisRef: String?, property: KProperty<*>): String {
            return delegateValue
        }

        override fun setValue(thisRef: String?, property: KProperty<*>, value: String) {
            delegateValue = value
        }

    }

    class ReadOnlyDelegate : ReadOnlyProperty<Any?, String> {

        val mValue: String

        constructor(value: String) {
            mValue = value
        }

        override fun getValue(thisRef: Any?, property: KProperty<*>): String {
            println("")
            return mValue
        }
    }

    private class UseMap(map: Map<String, Any?>) {
        val a: String by map
        val b: Int by map
    }

    private class UseMutableMap(map: MutableMap<String, Any?>) {
        var a: String by map
        var b: Int by map
    }

    //=======provideDelegate=======================================}
    fun TestProvideDelegate() {
        //扩展函数实现
        var delegateExtend by IntMe()
        delegateExtend = 9999
        println("delegateExtend-1 is " + delegateExtend)
        delegateExtend = 10001
        println("delegateExtend-2 is " + delegateExtend)
        //内置函数实现
        var delegateValue by ProvideDelegate()
        delegateValue = 9999
        println("delegateValue-1 is " + delegateValue)
        delegateValue = 10001
        println("delegateValue-2 is " + delegateValue)
    }

    class ProvideDelegate {
        operator fun provideDelegate(thisRef: Any?, prop: KProperty<*>)
                : DelegateSelf {
            return DelegateSelf()
        }
    }
    //=============================================================

    class DelegateSelf {
        operator fun getValue(thisRef: IntMe?, property: KProperty<*>): Int {
            println("getValue>> thisRef is $thisRef ;name is ${property.name}")
            return 10000
        }

        operator fun setValue(thisRef: IntMe?, property: KProperty<*>, value: Int) {

            println("setValue>> thisRef is $thisRef; value is $value; name is ${property.name}")
        }
    }

    class IntMe() {

    }

    fun testNormalDelegate() {
        var delegateSelf by DelegateSelf()
        delegateSelf = 9999
        println("delegateSelf-1 is " + delegateSelf)
        delegateSelf = 10001
        println("delegateSelf-2 is " + delegateSelf)
    }
}

operator fun DelegatePropertiesDemo.IntMe.provideDelegate(thisRef: Any?, prop: KProperty<*>)
        : DelegatePropertiesDemo.DelegateSelf {
    return DelegatePropertiesDemo.DelegateSelf()
}

