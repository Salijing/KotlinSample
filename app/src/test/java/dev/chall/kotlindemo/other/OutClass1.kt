package dev.chall.kotlindemo.other

/**
 * Created by chall on 2017/6/28.
 */
class OutClass1 {

    fun test() {

        ::testOut
    }
}
//var reflectVariable = 1

fun testOut() {
}

/**
在文件顶层写的变量和方法，在同一个包内是互相看见的，即使在不同文件中，使用了private等修饰符也不行（修饰符只会控制访问权限）也会相互冲突
 */