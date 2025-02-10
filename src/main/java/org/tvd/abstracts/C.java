package org.tvd.abstracts;

public class C implements A {

    @Override
    public void speak() {
        System.out.println("C say hello");
    }

    public void eat() {
        System.out.println("E is eating");
    }
}
