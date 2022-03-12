package com.maxwell.base.entity;


import com.maxwell.base.annotation.myhibernate.*;

import java.io.Serializable;

@Entity
@Table(name = "hero")
public class Hero implements Serializable {


    private long id;
    public String name;
    private double hp;
    private double armor;
    private long moveSpeed;
    private double damage;

    public Hero() {

    }

    public Hero(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = "identity")
    @Column("id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column("hp")
    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    @Column("armor")
    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    @Column("move_speed")
    public long getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(long moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    @Column("damage")
    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public synchronized void recover() {
        hp += 1;
        // 通知那些等待在this对象上的线程，可以醒过来了
        System.out.printf("英雄%s回复血量：%f%n", this.getName(), this.getHp());
        this.notify();
    }

    public synchronized void hurt() {
        if (hp == 1)
            try {
                //当血量为1时通知让占据同步对象的线程临时释放对象，等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        hp -= 1;
        System.out.printf("英雄%s受到1点伤害 血量：%f%n", this.getName(), this.getHp());
    }

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }

    public void attackHero(Hero h2) {
        System.out.println(this.name + " 正在攻击 " + h2.getName());
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", armor=" + armor +
                ", moveSpeed=" + moveSpeed +
                ", damage=" + damage +
                '}';
    }
}
