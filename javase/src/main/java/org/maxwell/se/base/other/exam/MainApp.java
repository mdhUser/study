package org.maxwell.se.base.other.exam;

import org.maxwell.se.base.other.exam.service.MathDemo;
import org.maxwell.se.base.other.exam.util.Add;
import org.maxwell.se.base.other.exam.util.Divide;
import org.maxwell.se.base.other.exam.util.Multiply;
import org.maxwell.se.base.other.exam.util.Subtract;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    private static ArrayList<MathDemo> mathDemos = new ArrayList<>();

    private static ArrayList<User> users = new ArrayList<>();


    static {
        mathDemos.add(new Add(1, 2));
        mathDemos.add(new Add(2.545, 4.6));
        mathDemos.add(new Multiply(2.5, 4.3));
        mathDemos.add(new Multiply(2.5, 4.3));
        mathDemos.add(new Divide(1113, 3));
        mathDemos.add(new Divide(6, 1));

        users.add(new Student("小芳", "123456"));
        users.add(new Student("小应", "123456"));
        users.add(new Student("小狄", "123456"));
        users.add(new Student("小毛", "123456"));
        users.add(new Student("小洁", "123456"));
        users.add(new Teacher("孔子", "123456"));
        users.add(new Teacher("庄子", "123456"));
    }


    public static void main(String[] args) {

        MainApp mainApp = new MainApp();
        mainApp.showUserUI(new Scanner(System.in), users, mathDemos);

    }


    public void addTest(Scanner input, ArrayList<MathDemo> math) {
        while (true) {
            System.out.println("当前题库如下：");
            for (int i = 0; i < math.size(); i++) {
                System.out.printf("问题%d:%s   参考答案：%f\n", i + 1, math.get(i).getQuestion(), math.get(i).calculate());
            }
            System.out.println("是否要编辑题目,需要编辑输入Y,输入其他无需修改，并退出登录！");
            if (input.next().equalsIgnoreCase("y")) {
                System.out.println("1.添加题目 \n2.删除题目");
                int in = input.nextInt();
                switch (in) {
                    case 1:
                        while (true) {
                            MathDemo mathQ;
                            System.out.println("请择需要添加的题型：\n" +
                                    "1:加法题\n" +
                                    "2:减法题\n" +
                                    "3:乘法题\n" +
                                    "4:除法题");
                            int type = input.nextInt();
                            switch (type) {
                                case 1:
                                    System.out.println("请输入被加数：");
                                    double a = input.nextDouble();
                                    System.out.println("请输入加数：");
                                    double b = input.nextDouble();
                                    mathQ = new Add();
                                    mathQ.setA(a);
                                    mathQ.setB(b);
                                    System.out.println("题目" + mathQ.getQuestion() + "添加成功！");
                                    mathDemos.add(mathQ);
                                    break;
                                case 2:
                                    System.out.println("请输入被减数：");
                                    double a1 = input.nextDouble();
                                    System.out.println("请输入减数：");
                                    double b1 = input.nextDouble();
                                    mathQ = new Subtract();
                                    mathQ.setA(a1);
                                    mathQ.setB(b1);
                                    System.out.println("题目" + mathQ.getQuestion() + "添加成功！");
                                    mathDemos.add(mathQ);
                                    break;
                                case 3:
                                    System.out.println("请输入被乘数：");
                                    double a3 = input.nextDouble();
                                    System.out.println("请输入乘数：");
                                    double b3 = input.nextDouble();
                                    mathQ = new Multiply();
                                    mathQ.setA(a3);
                                    mathQ.setB(b3);
                                    System.out.println("题目" + mathQ.getQuestion() + "添加成功！");
                                    mathDemos.add(mathQ);
                                    break;
                                case 4:
                                    System.out.println("请输入被除数：");
                                    double a2 = input.nextDouble();
                                    System.out.println("请输入除数：");
                                    double b2 = input.nextDouble();
                                    mathQ = new Divide();
                                    mathQ.setA(a2);
                                    mathQ.setB(b2);
                                    System.out.println("题目" + mathQ.getQuestion() + "添加成功！");
                                    mathDemos.add(mathQ);
                                    break;
                                default:
                                    System.out.println("请输入有效数字！");
                            }
                            System.out.println("是否继续添加题目，是请按Y，否则任意输入:");
                            if (!input.next().equalsIgnoreCase("y"))
                                break;
                        }
                        break;
                    case 2:
                        deleteTest(input, math);
                        break;
                    default:
                        System.out.println("无效数字！");
                }

            } else {
                System.out.println("退出登录！！");
                break;
            }
        }

    }

    public void deleteTest(Scanner input, ArrayList<MathDemo> math) {
        while (true) {
            System.out.println("当前题库如下：");
            for (int i = 0; i < math.size(); i++) {
                System.out.printf("问题%d:%s   参考答案：%f\n", i + 1, math.get(i).getQuestion(), math.get(i).calculate());
            }
            System.out.println("请输入要删除的题目编号：");
            int q = input.nextInt();
            if (q > math.size()) {
                System.out.println("请输入正确题目编号！");
                continue;
            }
            System.out.println("确认删除题目" + q + "请按Y否则按任意键退出！");
            if (input.next().equalsIgnoreCase("y")) {
                MathDemo mathDemo = mathDemos.remove(q - 1);
                System.out.println("删除题目" + mathDemo.getQuestion() + "成功！");
                System.out.println("是否继续删除题目？如是请输入Y其余任意键退出！");
                if (!input.next().equalsIgnoreCase("y")) {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public void answer(Scanner input, ArrayList<MathDemo> math) {
        for (; ; ) {
            System.out.printf("请开始您的答题：\n您好，一共%d道题目，请开始作答，答对一题得1分，答错不给分 \n", math.size());
            int score = 0;
            for (MathDemo mathDemo : math) {
                System.out.printf("请回答以下问题，机会只有一次：\n%s\n", mathDemo.getQuestion());
                if (mathDemo instanceof Divide)
                    System.out.println("这是一道除法题只需回答商即可其余不做考虑！");
                if (input.nextDouble() == mathDemo.calculate()) {
                    System.out.println("回答正确！");
                    score++;
                } else {
                    System.out.println("回答错误！");
                }
            }
            System.out.printf("一共%d道题，每题一分，共得分%d\n", math.size(), score);
            System.out.println("哇哦！算术这方面，你就是王者！佩服你成绩不服，输入Y继续挑战，否则输入其它退出！");
            String next = input.next();
            if (!next.equalsIgnoreCase("y")) {
                System.out.println("欢迎再来！");
                break;
            }
        }
    }


    public void showUserUI(Scanner input, ArrayList<User> users, ArrayList<MathDemo> mathDemos) {
        System.out.println("欢迎来到黑马小学生算术练习系统！");
        System.out.println("请输入用户名：");
        String name = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        boolean f = false;
        for (User user : users) {
            if (user instanceof Student
                    && user.getName().equals(name)
                    && user.getPassword().equals(password)) {
                f = true;
                System.out.println("欢迎" + name + "同学进入系统");
                answer(input, mathDemos);
                break;
            }
            if (user instanceof Teacher
                    && user.getName().equals(name)
                    && user.getPassword().equals(password)) {
                f = true;
                System.out.println("欢迎" + name + "老师进入系统");
                addTest(input, mathDemos);
                break;
            }
        }
        if (!f) {
            System.out.println("无此用户！");
        }
    }

}