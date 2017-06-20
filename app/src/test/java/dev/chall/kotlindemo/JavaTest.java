package dev.chall.kotlindemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chall on 2017/6/20.
 */

public class JavaTest {
    public static void main(String[] args) {
        ArrayList mList = new ArrayList<String>();//ArrayList<String> mList = new ArrayList<String>();
    }

    interface A {
        void A();
    }

    interface V {
        void A();
    }

    class C implements A,V{

        @Override
        public void A() {

        }
    }
}
