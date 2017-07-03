@file:JvmName("Kotlin2JavaSample")

//@file:JvmMultifileClass

package dev.chall.kotlindemo.java_kotlin

import android.renderscript.Int2
import android.text.InputType
import android.util.Log
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException

/**
 * Created by chall on 2017/6/29.
 */

/*begin================================================包级使用=======================================begin*/
const val valPkgConst = 1//无需注解，直接对外体现，相当于java里的static final，可通过问修饰符控制
var varPkgNoAnnoPublic = "varPkgNoAnno"//通过访问修饰符控制调用
private var varPkgNoAnnoprivate = "varPkgNoAnno"
internal var varPkgNoAnnoInternal = "varPkgNoAnno"
//lateinit var varPkglateinit= "varPkglateinit"//lateinit不可写在包级
@JvmField var varPkgJvmField = "varPkgJvmField"//JvmStatic只可在object中；文件不能使用@file:JvmMultifileClass注解，两者不可共存

fun funNoAnno() {//不支持@JvmField @JvmStatic注解
    println("funNoAnno")
}

/*end================================================包级使用=======================================end*/

/*begin================================================类级使用=====================================begin*/
@RunWith(JUnit4::class)
class Kotlin4Java {

    lateinit var varClassLateinit: String//lateinit不需要注解对外体现，不像const，其不具备static属性，也可通过set、get操作
    var varClassNoAnno = "varNoAnno"
    @JvmField var varClassJvmField = "varJvmField"//JvmStatic只允许在object中

    constructor() {}
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


    @Test
    fun doTest() {
    }
}

/*end================================================类级使用=======================================end*/

/*begin================================================Obejct使用=====================================begin*/
object PkgObject {
    const val objectConst = ""
    lateinit var objectLate: String
    @JvmStatic var varObjectJvmStatic = ""
    @JvmField var varObjectJvmField = ""
    var varNoAnno = ""

    @JvmStatic fun funObjectJvmStatic() {}
    fun funObjectNoAnno() {}
}

/*end================================================Obejct使用=======================================end*/


