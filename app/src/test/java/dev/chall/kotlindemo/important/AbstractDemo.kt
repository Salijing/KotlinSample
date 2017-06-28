package dev.chall.kotlindemo.important

/**
 * Created by chall on 2017/6/21.
 */
abstract class AbstractDemo {
    abstract fun <T : String> abstractFun(values: String = "", name: T): Int

    fun normalFun() {

    }
}