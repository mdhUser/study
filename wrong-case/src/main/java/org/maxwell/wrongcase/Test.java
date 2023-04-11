package org.maxwell.wrongcase;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/27 13:37
 */
public class Test {
    static Pattern p = Pattern.compile("^[0-9]*$");
    static Pattern regxNums = Pattern.compile("\\d+(\\.\\d+)?");
    private ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    //获得JavaScript脚本引擎
     private ScriptEngine jsEngine = scriptEngineManager.getEngineByName("js");
    public static void main(String[] args) {

        Matcher matcher = regxNums.matcher("12.35");
        System.out.println("matcher.find() = " + matcher.matches());

    }

    private static void test1() {
        String goodsNum = "100.334";
        Matcher m = p.matcher(goodsNum);
        if (!m.matches()) {
            System.out.println("error1");
        }

        if ( goodsNum.split("\\.").length > 2) {
            System.out.println("error2");
        }
    }

}
