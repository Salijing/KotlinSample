package chall.dev.kotlindemo

import android.content.Context
import android.view.View

/**
 * <p>write the description
 * @author songchao
 * @version [当前项目版本]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

public class Utils {
    fun View.sayAgain(): Context {
        return this.context;
    }
}

val View.ctx: Context
    get() = this.context

 fun View.helloContext(): Context {
    return this.context
}