package chall.dev.kotlindemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list.view.*

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

class TestAdapter : BaseAdapter() {
    override fun getCount(): Int {
        return 1
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View? {
        val view1 = LayoutInflater.from(parent.context).inflate(R.layout.item_list, null)
        view1.itemtext.text = "123"
        return view1
    }
}
