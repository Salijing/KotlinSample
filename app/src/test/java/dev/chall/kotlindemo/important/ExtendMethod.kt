package dev.chall.kotlindemo.important

import important.ConstructDemo

private fun ConstructDemo.sayHey(msg: String) {
    println("it say $msg")
}

//不可变
val ConstructDemo.extendTest1: String
    get() = this.aValue
//可变
internal var ConstructDemo.extendTest2: String
    get() = this.aValue
    set(value) {
        this.aValue = value
    }