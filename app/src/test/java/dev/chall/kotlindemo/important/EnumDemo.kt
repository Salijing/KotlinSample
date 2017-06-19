package dev.chall.kotlindemo.important

import important.ConstructDemo
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.ArrayList

/**
 * Created by chall on 2017/6/19.
 */
@RunWith(JUnit4::class)
class EnumDemo {
    @Test
    @Throws(Exception::class)
    fun useEnum() {

        println("A-label is ${Values.A.label}")
        println("B-label is ${Values.B.label}")
        Values.B.label = "tellME"
        println("B-label changed-> ${Values.B.label}")
        Values.A.testEnum()
        Values.B.testEnum()

        Values.values().forEach {
            println("name is "+it.name + ";ordinal is " + it.ordinal + " " + Values.valueOf(it.name).label)
        }
        println("Values-A-label is "+Values.valueOf("A").label)
        Values.valueOf("FF")
    }

    enum class Simple {
        EnumA, EnumB, EnumC;
    }

    enum class Simple1(index: Int) {
        EnumD(1), EnumE(2), EnumF(3);
    }
}

enum class Values() {
    A {
        override var label = "isA"
    },
    B {
        override fun testEnum() {
            println("欢欢喜喜过大年")
        }
    },
    C;

    open var label = "unknown"
    open fun testEnum() {
        println("无语")
    }
}


