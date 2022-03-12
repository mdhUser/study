package my.demo

/**
 * @description: 基本语法3
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/18 21:43
 */

fun main() {

    //区间使用
    val x = 10
    var y = 9
    if (x in 1..y + 1)
        println("fits in range")

    val list = listOf("a", "b", "c")

    //区间外
    if (-1 !in 0..list.lastIndex)
        println("-1 is out of range")

    if (list.size !in list.indices)
        println("list size is out of valid list indices range, too")
    println()

    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
//sample


}