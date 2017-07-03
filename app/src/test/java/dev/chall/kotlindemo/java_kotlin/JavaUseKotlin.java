package dev.chall.kotlindemo.java_kotlin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by chall on 2017/6/20.
 */
@RunWith(JUnit4.class)
public class JavaUseKotlin {

    @Test
    public void test() {

        /** ============pkg============
         * 包级无论何种引用变量，变量都是static(静态的)
         */
        Kotlin2JavaSample.funNoAnno();
        int valPkgConst = Kotlin2JavaSample.valPkgConst;
        Kotlin2JavaSample.getVarPkgNoAnnoPublic();
        Kotlin2JavaSample.setVarPkgNoAnnoPublic("设置包级无field注解变量-public");
        Kotlin2JavaSample.getVarPkgNoAnnoInternal();
        Kotlin2JavaSample.setVarPkgNoAnnoInternal("设置包级无field注解变量-internal");
        //Kotlin2JavaSample.getVarPkgNoAnnoPrivate();
        String varPkgJvmField = Kotlin2JavaSample.varPkgJvmField;
        /*通过文件生成类，是无法生成对象的哦。（Error:(31, 47) 错误: 找不到符号;符号:   构造器 Kotlin2JavaSample()）*/
        //Kotlin2JavaSample kotlin2JavaSample = new Kotlin2JavaSample();
        //kotlin2JavaSample.getVarPkgNoAnno();

        /** ============class============
         *
         */
        //初始化
        Kotlin4Java kotlin4Java = new Kotlin4Java();
        kotlin4Java = new Kotlin4Java(1, 1, "");

        //类级变量
        String varClassJvmField = kotlin4Java.varClassJvmField;
        kotlin4Java.getVarClassNoAnno();
        kotlin4Java.setVarClassNoAnno("设置可访问无注解变量的值");
        String valClassLateinit = kotlin4Java.varClassLateinit;//lateinit
        kotlin4Java.getVarClassLateinit();
        kotlin4Java.setVarClassLateinit("设置类级lateinit");

        //co变量
        String valCompanionObjectConst = Kotlin4Java.valCompanionObjectConst;
        String varCompanionObjectJvmField = Kotlin4Java.varCompanionObjectJvmField;
        String varCompanionObjectLateinit = Kotlin4Java.varCompanionObjectLateinit;
        //使用@JvmStatic两种调用
        Kotlin4Java.Companion.setVarCompanionObjectJvmStatic("");//建议，清晰一点
        Kotlin4Java.setVarCompanionObjectJvmStatic("");
        Kotlin4Java.Companion.getVarCompanionObjectJvmStatic();
        Kotlin4Java.getVarCompanionObjectJvmStatic();
        //无注解（lateinit也可这样使用）
        Kotlin4Java.Companion.getVarCompanionObjectNoAnno();//注意Companion,代表调用伴随变量

        //类方法
        kotlin4Java.funClassNoAnno();
        kotlin4Java.getVarClassNoAnno();//获取变量也是方法哦
        kotlin4Java.getVarClassNoAnnoByFun();

        //cb方法
        Kotlin4Java.funCompanionObjectFunJvmStatic();
        Kotlin4Java.Companion.funCompanionObjectFunJvmStatic();//建议，清晰一点
        Kotlin4Java.Companion.funCompanionObjectFunNoAnno();

        //object in Class,使用见下Object
        Kotlin4Java.ClassObject classObject = Kotlin4Java.ClassObject.INSTANCE;
        classObject.getVarObjectInClass();

        //============object，变量都是static============
        //const
        String objectConst = PkgObject.objectConst;
        //lateinit
        String objectLate = PkgObject.objectLate;
        //@JvmStatic，不注解无法通过类名调用
        Object varObjectJvmStatic = PkgObject.getVarObjectJvmStatic();
        PkgObject.setVarObjectJvmStatic("");
        //@JvmField，不注解无法通过类名调用
        String varObjectJvmField = PkgObject.varObjectJvmField;
        //@JvmStatic,不支持@JvmField，不注解无法通过类名调用
        PkgObject.funObjectJvmStatic();
        //生成对象,全部可以调用
        PkgObject pkgObject = PkgObject.INSTANCE;
        System.out.println("ja3-before-> " + pkgObject.getVarNoAnno());//ja1-ja2都可以调，就不说了
        pkgObject.setVarNoAnno("ja3");
        System.out.println("ja3-after-> " + pkgObject.getVarNoAnno());
        pkgObject.funObjectNoAnno();
        pkgObject.funObjectJvmStatic();//建议直接用类名调用


        //lateinit
        //Pkg不支持
        //object
        System.out.println(PkgObject.objectLate);
        PkgObject.objectLate = "object initlate";
        System.out.println(PkgObject.objectLate);
        //class
        KotlinTest initLate = new KotlinTest();
        System.out.println(initLate.classLateinit);
        initLate.getClassLateinit();
        initLate.setClassLateinit("");
    }

}
