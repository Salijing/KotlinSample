package chall.dev.kotlindemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {
    companion object {
        var hahha = "";

        fun hqhq() {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listview.adapter = TestAdapter();


        hello.text = "你好吗"
        var ttt = findViewById(R.id.hello) as TextView
        ttt.text = ("asdasdasdcasdaskljdfhliuashndvwyrusdh")
        var clickll = View.OnClickListener {
            fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        ttt.setOnClickListener {
            clickll
        }
        var mList = listOf(1, 2, 3)
        var gantan = mList!!

        var classInt: Int = 1;
        var classDouble: Double = classInt.toDouble();
        var classChar: Char = 'a'
        classInt = (classChar + 1).toInt()
//        showMsg("hahah")
        var mDog = Dog("haha", 1, 1)
        doAsync {
            getInfo("https://www.baidu.com")
            uiThread { }
        }
        var mFuture = doAsyncResult {
            getInfo("https://www.baidu.com")
        }
        android.util.Log.e("Sysout", "async result get is " + mFuture.get())

        var dogA = Dog("Dog A", Color.RED, 11)

        var dogASwitchColor = dogA.copy(color = Color.BLUE, age = 15)
        var (nameA, colorA, ageA) = dogA
        var mapA = mapOf<String, Int>(Pair("", 1), "" to 1)
        for ((key, value) in mapA) {

        }
//**********************************************************************************************
        var viewGrop = LinearLayout(this)
//        viewGrop.get(1)

        hello.setOnClickListener {
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
        }

        hello.setOnClickListener { toast("") }

        val testInner1 = Dog.NotInnerDisplay()
//        val testInner2 = Dog.hasInnerDiaplay()

    }

    fun initUI(age: Integer): Boolean {
        return true
    }

    public var TextView.text: CharSequence
        get() = getText()
        set(v) = setText(v)

    fun getInfo(url: String) {
        var request = URL(url).readText();
        android.util.Log.e("Sysout", request)
        testInline { getInfo(url) }
    }


//    operator fun ViewGroup.get(positon: Int): Unit{
//
//    }

    operator fun ViewGroup.contains(hah: Any): Boolean {
        println("getpag hahaha")
        return false
    }

    operator fun compareTo(obj: Any?): Int {
        return 0
    }

    inline fun testInline(noinline notInlined: () -> Unit) {

    }


}
