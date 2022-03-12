package com.maxwell.base.other.exam.util;


import com.maxwell.base.other.exam.service.MathDemo;

public class Subtract extends MathDemo {

    public Subtract() {
    }

    public Subtract(double a, double b) {
        super(a, b);
    }

    @Override
    public double calculate() {
        return a-b;
    }

    @Override
    public String getQuestion() {
        return a+"-"+b+"=?";
    }
}