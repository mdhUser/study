package my.demo

/**
 * @description:基本语法2
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/18 17:19
 */

fun main() {

    //定义只读局部变量使用关键字 val 定义。只能为其赋值一次。
    val a: Int = 1  // 立即赋值
    val b = 2   // 自动推断出 `Int` 类型
    val c: Int  // 如果没有初始值类型不能省略
    c = 3       // 明确赋值

    println("a=$a,b=$b,c=$c")

    //可重新赋值的变量使用 var 关键字。
    var x = 5
    x += 1;
    println(x)

    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) println(item)
    println("=============================")
    for (index in items.indices) println("item at $index is ${items[index]}")
    println("=============================")

    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))

}

fun describe(obj: Any): String = when (obj) {
    1 -> "One"
    "Hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "Not a String"
    is String -> "Is a String"
    else -> "Unknown"
}