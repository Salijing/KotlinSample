package dev.chall.kotlindemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dev.chall.kotlindemo.java_kotlin.Kotlin4Java;

/**
 * Created by chall on 2017/7/4.
 */
@RunWith(JUnit4.class)
public class JavaTest {

    @Test
    public void doTest() {
        Kotlin4Java kotlin4Java = new Kotlin4Java(1);
//        String varClassJvmFieldProtected = kotlin4Java.varClassJvmFieldProtected;
// kotlin-protected->java-protected
    }
}
