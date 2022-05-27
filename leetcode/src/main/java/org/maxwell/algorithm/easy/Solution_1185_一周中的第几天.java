package org.maxwell.algorithm.easy;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/26 16:41
 */
public class Solution_1185_一周中的第几天 {

    class Solution {
        public String dayOfTheWeek(int day, int month, int year) {
            String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
            /* 输入年份之前的年份的天数贡献 */
            int days = 365 * (year - 1971) + (year - 1969) / 4;
            /* 输入年份中，输入月份之前的月份的天数贡献 */
            for (int i = 0; i < month - 1; ++i) {
                days += monthDays[i];
            }
            if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
                days += 1;
            }
            /* 输入月份中的天数贡献 */
            days += day;
            return week[(days + 3) % 7];
        }
    }

    /**
     *  蔡勒公式
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static String dayOfTheWeek(int day, int month, int year) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        return weekDays[week];
    }

    public static void main(String[] args) {

        System.out.println(dayOfTheWeek(28, 5, 2022));

    }

}