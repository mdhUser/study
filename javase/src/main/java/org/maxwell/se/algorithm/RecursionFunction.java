package org.maxwell.se.algorithm;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/26 21:51
 */
public class RecursionFunction {

    public static void main(String[] args) {
        System.out.println(f(5));
    }


  public static int f(int x){
      if (x==0)
          return 0;
      else
          return 2*f(x-1)+x*x;
  }



}
