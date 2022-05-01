package org.maxwell.algorithm.easy;

import java.util.Arrays;

/**
 * @description: 救生艇
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/20 17:36
 */
public class Solution_881 {


    /**
     *  贪心算法
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {

        int r=people.length-1,l=0,ans=0;
        Arrays.sort(people);
        while(l<=r){

            if(l==r) {
                ++ans;
                break;
            }
            else if(people[l]+people[r]>limit){
                ++ans;
                r--;
            }
            else{
                ++ans;++l;--r;
            }
        }

        return ans;
    }


}
