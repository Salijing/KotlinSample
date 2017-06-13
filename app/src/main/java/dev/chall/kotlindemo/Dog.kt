package chall.dev.kotlindemo

/**
 * <p>write the description
 * @author songchao
 * @version [当前项目版本]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
data class Dog(var name: String, var color: Int, val age: Int) : Animals(name) {

    init {
        cal(1)
    }

    fun cal(x: Int, y: Int = 2, z: Int = 3): Int = x + y + z

    class NotInnerDisplay {

    }

    inner class hasInnerDiaplay() {

    }

}