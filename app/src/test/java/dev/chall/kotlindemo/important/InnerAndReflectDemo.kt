package chall.dev.kotlindemo

import android.content.Context
import android.view.View
import android.view.ViewGroup

/**
 *
 * write the description

 * @author songchao
 * *
 * @version [当前项目版本]
 * *
 * @see [相关类/方法]

 * @since [产品/模块版本]
 */

class InnerAndReflectDemo(context: Context?) : ViewGroup(context) {

    public var test123 = "haha"

    constructor(i: Int) : this(null) {

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun resetIndex(index: Int) {
        println("reset index is " + index)
    }

    inner class testInnerClass() {

    }

}
