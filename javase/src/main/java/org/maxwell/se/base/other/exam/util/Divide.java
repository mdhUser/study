package org.maxwell.se.base.other.exam.util;


import org.maxwell.se.base.other.exam.service.MathDemo;

public class Divide extends MathDemo {


    public Divide(double a, double b) {
        super(a, b);
    }

     public Divide() {
     }

    @Override
    public double calculate() {
        return a/b;
    }

    @Override
    public String getQuestion() {
        return a+"÷"+b+"=?";
    }
}
