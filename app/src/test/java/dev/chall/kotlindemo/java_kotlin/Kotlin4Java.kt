@file:JvmName("Kotlin2JavaSample")

//@file:JvmMultifileClass

package dev.chall.kotlindemo.java_kotlin

import android.renderscript.Int2
import android.text.InputType
import android.util.Log
import dev.chall.kotlindemo.important.extendTest2
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException
import java.util.zip.InflaterOutputStream

/**
 * Created by chall on 2017/6/29.
 */

/*begin================================================包级使用=======================================begin*/
const val valPkgConst = 1//无需注解，直接对外体现，相当于java里的static final，可通过问修饰符控制
var varPkgNoAnnoPublic = "varPkgNoAnno"//通过访问修饰符控制调用
var isPkgNoAnnoValue = false//通过访问修饰符控制调用
private var varPkgNoAnnoprivate = "varPkgNoAnno"
internal var varPkgNoAnnoInternal = "varPkgNoAnno"
//lateinit var varPkglateinit= "varPkglateinit"//lateinit不可写在包级
@JvmField var varPkgJvmField = "varPkgJvmField"//JvmStatic只可在object中；文件不能使用@file:JvmMultifileClass注解，两者不可共存
@JvmField internal var varPkgJvmFieldInternal = "varPkgNoAnno"

internal var varClassNoAnnoInternal = "varClassNoAnnoInternal"
fun funNoAnno() {//不支持@JvmField @JvmStatic注解
    println("funNoAnno")
}

/*end================================================包级使用=======================================end*/

/*begin================================================类级使用=====================================begin*/
open class Kotlin4Java {

    lateinit var varClassLateinit: String//lateinit不需要注解对外体现，不像const，其不具备static属性，也可通过set、get操作
    var varClassNoAnno = "varNoAnno"
    var isClassNoAnno = false
    internal var varClassNoAnnoInternal = "varClassNoAnnoInternal"
    @JvmField public var varClassJvmFieldPublic = "varClassJvmFieldPublic"//JvmStatic只允许在object中
    @JvmField internal var varClassJvmFieldInternal = "varClassJvmFieldInternal"//JvmStatic只允许在object中
    @JvmField protected var varClassJvmFieldProtected = "varClassJvmFieldProtected"//JvmStatic只允许在object中
//    @JvmField private var varClassJvmFieldPrivate = "varJvmField"//JvmStatic只允许在object中

    private constructor() {}
    constructor(index: Int) {}
    constructor(index: Int, type: Int, name: String = "") {}

    companion object {
        const val valCompanionObjectConst = "classConst"//仅允许在包级和object中
        lateinit var varCompanionObjectLateinit: String
        var varCompanionObjectNoAnno = "companionObjectNoAnno"
        @JvmField var varCompanionObjectJvmField = "companionObjectJvmField"//private修饰无意义哦，因为@Filed就没作用了
        @JvmStatic var varCompanionObjectJvmStatic = "companionObjectJvmStatic"

        @JvmStatic fun funCompanionObjectFunJvmStatic() {}

        fun funCompanionObjectFunNoAnno() {}
    }

    object ClassObject {
        var varObjectInClass = "varObjectInClass"
    }

    fun funClassNoAnno() {//不支持@JvmField @JvmStatic注解
        println("funClassNoAnno")
    }

    @JvmName("getVarClassNoAnnoByFun")
    fun getVarClassNoAnno() = "class中方法调用"

    @JvmOverloads//不加java类只能重写全部的参数
    open fun overideFun(x: Int, y: Int = 1, z: Int = 2) {
    }

    fun inputClass(cc: Kotlin4Java) {}

    @Throws(IOException::class) //这样，1.java代码才能精确捕获IOException；2.有异常提示
    fun funThrowsException() {
        throw IOException()
    }
}

/*end================================================类级使用=======================================end*/

/*begin================================================Obejct使用=====================================begin*/
object PkgObject {
    const val objectConst = ""
    lateinit var objectLateinit: String
    @JvmStatic var varObjectJvmStatic = "varObjectJvmStatic old-value"
    @JvmStatic internal var varObjectJvmStaticInternal = "varObjectJvmStaticInternal"
    @JvmField var varObjectJvmField = ""
    @JvmField internal var varObjectJvmFieldInternal = "varObjectJvmFieldInternal"
    var varNoAnno = ""
    internal var varNoAnnoInternal = "varNoAnnoInternal"

    @JvmStatic fun funObjectJvmStatic() {}
    fun funObjectNoAnno() {}
}

/*end================================================Obejct使用=======================================end*/


fun Kotlin4Java.sayHey(msg: String) {
    println(msg)
}

//这样写会死的惨惨的，get请求flag值，于是又去掉get，陷入死循环了，set也是这也（这边一般不设置变量自身，而是设置对应类的属性）
var Kotlin4Java.flag: String
    get() = this.flag
    set(value) {
        this.flag = value
    }

var Kotlin4Java.varClassNoAnnoValue: String
    get() = this.varClassNoAnno
    set(value) {
        this.varClassNoAnno = value
    }


@RunWith(JUnit4::class)
class ThisTest() {
    @Test
    fun doTest() {

        var value = String() ?: println("is null")//不为空返回自身


        var kotlinTest = Kotlin4Java(1)
        println(kotlinTest.varClassNoAnnoValue)
        kotlinTest.varClassNoAnnoValue = "new value"
        println(kotlinTest.varClassNoAnnoValue)
        mmap = mmap1
        throwError()


    }


    var mmap: MutableMap<String, String>? = null;
    var mmap1 = mutableMapOf<String, String>()


    private fun throwError(): Nothing {//Nothing啥都木有,用来表达永不返回的函数
        mmap?.put("","2")
        throw IllegalArgumentException("Name required")//crash，无返回
    }
}
