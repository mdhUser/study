package my.demo

/**
 * @description:开始第一个kotlin程序
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/18 16:07
 */


fun main(args: Array<String>) {

    //打印
//    print("hello")
//    print("world!")

    println(sum(3, 4))
    println("sum of 19 and 23 is ${sum2(19, 23)}")

    val rectangle = Rectangle(5.2, 2.4)
    println("The perimeter is ${rectangle.perimeter}")
    println()

    /**
     * 字符串替换
     */
    var a = 1
    // 模板中的简单名称：
    val s1 = "a is $a"

    a = 2
    // 模板中的任意表达式：
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)

    println("max of 0 and 42 is ${maxOf(0, 42)}")

}

/**
 * 方法
 */
fun sum(a: Int, b: Int): Int {

    return a + b
}

fun sum2(a: Int, b: Int) = a + b

/**
 * 继承
 */
open class Shap

class Rectangle(height: Double, leight: Double) : Shap() {

    var perimeter = (height + leight) * 2
}

//if
//fun maxOf(a:Int,b:Int):Int{
//
//    if (a>b)
//        return a
//    else
//        return b
//
//}

//if表达式
fun maxOf(a: Int, b: Int) = if (a > b) a else b



