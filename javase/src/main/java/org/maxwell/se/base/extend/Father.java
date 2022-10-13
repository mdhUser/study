package org.maxwell.se.base.extend;

public abstract class Father {

    private int age;
    private int id;
    private String name;

    public Father(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.printf("我是爸爸%n");
    }

    public abstract String fuck();

}

class Son extends Father {


    public Son(String name) {
        super(name);
        this.setName("axiba");
    }



    @Override
    public String fuck() {
        return String.format("%s fucking U %s %d %n",this.getName(),super.getName(),this.getAge());
    }

    @Override
    public void show() {
        super.show();
        System.out.println("我是儿子!");
    }

    public static void main(String[] args) {
        Son son = new Son("DUCK");
        System.out.println(son.getName());
        System.out.println(son.getAge());
        son.show();
        System.out.println(son.fuck());
    }


}


