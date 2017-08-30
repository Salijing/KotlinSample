package dev.chall.kotlindemo;

import android.support.annotation.NonNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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

        SuperClass<String> st = new SuperClass(new SuperInit<String>() {
            @Override
            public String create() {
                return "1212";
            }
        });
        st.println();

        SuperClass<Integer>[] sc = (SuperClass<Integer>[]) new SuperClass[3];
        sc[0] = new SuperClass<Integer>(1);
        sc[1] = new SuperClass<Integer>(2);
        System.out.print(sc[0].getValue() + "  " + sc[1].getValue() + " " + sc.length);

        final MList mList = new MList();
        final ReadWriteLock rwl = new ReentrantReadWriteLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    rwl.writeLock().lock();
                    mList.setIndex();
                    rwl.writeLock().unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    rwl.writeLock().lock();
                    mList.setIndex();
                    rwl.writeLock().unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
               while(true){
                   try {
                       Thread.sleep(200);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(mList.getIndex());
               }
            }
        }).start();

        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MList<T> {
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex() {
        this.index++;
    }
}

class SuperClass<T extends Object> {
    private T mT;

    private T mValue;

    public SuperClass(T value) {
        mValue = value;
    }

    public T getValue() {
        return mValue;
    }

    public SuperClass(SuperInit<T> superInit) {
        mT = superInit.create();
    }

    public void println() {
        System.out.println(mT);
    }
}

interface SuperInit<T> {
    T create();
}

class SuperInitC<T> {
}

class SuperInit1 extends SuperInitC {
}

class SuperInit2 extends SuperInitC {
}
