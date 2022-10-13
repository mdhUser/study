package org.maxwell.se.base.en;

public enum Sex {
    GIRL(22, "Easter"), BOY(22, "Maxwell");

    private int age;
    public String name;

     Sex(int age, String name) {
        this.age = age;
        this.name = name;
    }


}


class Student {

    public static void main(String[] args) {

        System.out.println(Sex.GIRL.name);
        System.out.println(Sex.BOY);
    }

}