package org.maxwell.se.base.other.exam.service;

public abstract class MathDemo implements Calculator {

    public MathDemo() {
    }

    public MathDemo(double a, double b) {
        this.a = a;
        this.b = b;
    }

    protected double a;

    protected double b;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public abstract String getQuestion();

}