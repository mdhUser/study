package org.maxwell.se.base.other.exam.util;

import org.maxwell.se.base.other.exam.service.MathDemo;

public class Add extends MathDemo {

    public Add(){
    }

    public Add(double a, double b) {
        super(a, b);
    }

    @Override
    public double calculate() {
        return a+b;
    }

    @Override
    public String getQuestion() {
        return a+"+"+b+"=?";
    }
}
