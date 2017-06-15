package dev.chall.kotlindemo

import android.content.Context
import important.ConstructDemo

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import java.util.ArrayList

import org.junit.Assert.assertEquals

/**
 * Instrumentation test, which will execute on an Android device.

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(JUnit4::class)
class ExampleInstrumentedTest {
    @Test
    @Throws(Exception::class)
    fun use123() {

        val al = ArrayList<String>()
        al.add("a")
        al.add("b")

        println("static int -> "+ConstructDemo.staticInt)
        ConstructDemo.staticInt = 10
        println("static int -> "+ConstructDemo.staticInt)
        ConstructDemo.doStatic()

    }
}
