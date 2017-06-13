package chall.dev.kotlindemo

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import java.util.*

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

class AsyncTaskDemop : Activity() {

    private var mTask: MyTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (null != mTask && mTask!!.status != AsyncTask.Status.FINISHED) {
            mTask!!.cancel(true)
            mTask = null
        }
        mTask = MyTask(object : Callback {
            override fun callback() {
                Toast.makeText(this@AsyncTaskDemop, "hahhah callback", Toast.LENGTH_SHORT).show()
            }
        })
        mTask!!.execute("asdas")

    }

    private inner class MyTask(val mCallback: Callback) : AsyncTask<Any, Any, Any>() {

        protected override fun doInBackground(params: Array<Any>): Any? {

            return null
        }

        override fun onPreExecute() {
            super.onPreExecute()
        }

        protected override fun onPostExecute(o: Any) {
            mCallback.callback()
            super.onPostExecute(o)
        }

        protected override fun onProgressUpdate(values: Array<Any>) {
            super.onProgressUpdate(*values)
        }

        protected override fun onCancelled(o: Any) {
            super.onCancelled(o)
        }

        override fun onCancelled() {
            super.onCancelled()
        }
    }

    private interface Callback {
        fun callback()
    }
}
