package chall.dev.kotlindemo

/**
 * <p>write the description
 * @author songchao
 * @version [当前项目版本]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

interface InterfaceDemo<A> {
    fun execute(): A

    //可以拥有具体实现
    fun execute(type: Int) {
        print("")
    }
}