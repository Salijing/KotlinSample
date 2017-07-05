package dev.chall.kotlindemo.java_kotlin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.Iterator;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KFunction;

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
        String varPkgJvmField = Kotlin2JavaSample.varPkgJvmField;//kotlin-public->java-public
        String varPkgJvmFieldInternal =
                Kotlin2JavaSample.varPkgJvmFieldInternal;//kotlin-internal->java-public
        //Kotlin2JavaSample.getVarPkgNoAnnoPrivate();//kotlin-privite->java-private
        Kotlin2JavaSample.getVarPkgNoAnnoPublic();
        Kotlin2JavaSample.setVarPkgNoAnnoPublic("设置包级无field注解变量-public");
        Kotlin2JavaSample.getVarPkgNoAnnoInternal();
        Kotlin2JavaSample.setVarPkgNoAnnoInternal("设置包级无field注解变量-internal");

        Kotlin2JavaSample.isPkgNoAnnoValue();
        Kotlin2JavaSample.setPkgNoAnnoValue(true);

        /*通过文件生成类，是无法生成对象的哦。（Error:(31, 47) 错误: 找不到符号;符号:   构造器 Kotlin2JavaSample()）*/
        //Kotlin2JavaSample kotlin2JavaSample = new Kotlin2JavaSample();
        //kotlin2JavaSample.getVarPkgNoAnno();

        /** ============class============
         *
         */
        //初始化
        Kotlin4Java kotlin4Java = new Kotlin4Java(1);
        kotlin4Java = new Kotlin4Java(1, 1, "");

        //类级变量
        String varClassJvmFieldPublic =
                kotlin4Java.varClassJvmFieldPublic;//kotlin-public->java-public
        String varClassJvmFieldInternal =
                kotlin4Java.varClassJvmFieldInternal;//kotlin-public->java-public
        //类变量internal无注解，不知道为啥总报错，不如加个@JvmField算了，哈哈，这种用法只有包变量是OK的
//        kotlin4Java.getVarClassNoAnnoInternal$test_sources_for_module_app();
        String varClassJvmFieldProtected =
                kotlin4Java.varClassJvmFieldProtected;//kotlin-protected->java-protected(不同包不可调用)
        kotlin4Java.getVarClassNoAnno();
        kotlin4Java.setVarClassNoAnno("设置可访问无注解变量的值");

        kotlin4Java.isClassNoAnno();
        kotlin4Java.setClassNoAnno(true);

        String valClassLateinit = kotlin4Java.varClassLateinit;//lateinit
        //选调用get会因为varClassLateinit未初始化而报错：kotlin.UninitializedPropertyAccessException: lateinit
        // property varClassLateinit has not been initialized
        kotlin4Java.setVarClassLateinit("设置类级lateinit");
        kotlin4Java.getVarClassLateinit();

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
        Kotlin2JavaSample.sayHey(kotlin4Java, "haha, form java");
        System.out.println("start-flag-> " + Kotlin2JavaSample.getVarClassNoAnnoValue(kotlin4Java));
        Kotlin2JavaSample.setVarClassNoAnnoValue(kotlin4Java, "give a new-value");
        System.out.println("end-flag -> " + Kotlin2JavaSample.getVarClassNoAnnoValue(kotlin4Java));
        //kotlin.jvm.JvmClassMappingKt.getKotlinClass(KClass)  反射获取Kotlin的类
        Iterator<KFunction<Kotlin4Java>> kotlin4JavaIterator = JvmClassMappingKt.getKotlinClass(
                Kotlin4Java.class).getConstructors().iterator();
        kotlin4JavaIterator.next();
        kotlin4Java.inputClass(kotlin4JavaIterator.next().call(1));//通过反射获取类对象

        //cb方法
        Kotlin4Java.funCompanionObjectFunJvmStatic();
        Kotlin4Java.Companion.funCompanionObjectFunJvmStatic();//建议，清晰一点
        Kotlin4Java.Companion.funCompanionObjectFunNoAnno();

        //object in Class,使用见下Object
        Kotlin4Java.ClassObject classObject = Kotlin4Java.ClassObject.INSTANCE;
        classObject.getVarObjectInClass();

        //============object，变量都是static============
        String objectConst = PkgObject.objectConst;//const
        String objectLate = PkgObject.objectLateinit;//lateinit
        String varObjectJvmField = PkgObject.varObjectJvmField;//@JvmField，不注解无法通过类名调用
        //@JvmStatic、不加注解无法通过类名调用
        Object varObjectJvmStatic = PkgObject.getVarObjectJvmStatic();
        System.out.println("varObjectJvmStatic-before >> " + PkgObject.getVarObjectJvmStatic());
        PkgObject.setVarObjectJvmStatic("varObjectJvmStatic new-values");
        System.out.println("varObjectJvmStatic-after >> " + PkgObject.getVarObjectJvmStatic());
        //方法 ： @JvmStatic,不支持@JvmField，不注解无法通过类名调用
        PkgObject.funObjectJvmStatic();
        //生成对象,全部可以调用
        PkgObject pkgObject = PkgObject.INSTANCE;
        System.out.println("varNoAnno-before-> " + pkgObject.getVarNoAnno());//ja1-ja2都可以调，就不说了
        pkgObject.setVarNoAnno("varNoAnno new-value");
        System.out.println("varNoAnno-after-> " + pkgObject.getVarNoAnno());
        pkgObject.funObjectNoAnno();
        pkgObject.funObjectJvmStatic();//建议直接用类名调用
        //        pkgObject.getVarNoAnnoInternal$test_sources_for_module_app();
        // -和类中使用internal吧不直接变量类似，我也很无奈啊-
        //        PkgObject.getVarObjectJvmStaticInternal$test_sources_for_module_app();
        String varObjectJvmFieldInternal = PkgObject.varObjectJvmFieldInternal;

        //lateinit
        //Pkg不支持
        //object
        System.out.println("objectLateinit - before ->> " + PkgObject.objectLateinit);
        PkgObject.objectLateinit = "object initlate";
        System.out.println("objectLateinit - after ->> " + PkgObject.objectLateinit);
        //class
        Kotlin4Java initLate = new Kotlin4Java(1);
        System.out.println(initLate.varClassLateinit);
        initLate.setVarClassLateinit("");
        initLate.getVarClassLateinit();

        try {
            kotlin4Java.funThrowsException();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class ExtendClass extends Kotlin4Java {

        public ExtendClass(int index) {
            super(index);
        }

        @Override
        public void overideFun(int x, int y, int z) {
            super.overideFun(x, y, z);
        }

        @Override
        public void overideFun(int x) {
            super.overideFun(x);
        }

        @Override
        public void overideFun(int x, int y) {
            super.overideFun(x, y);
        }
    }
}
