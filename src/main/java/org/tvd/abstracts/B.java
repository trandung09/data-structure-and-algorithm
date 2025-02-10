package org.tvd.abstracts;

public class B implements A {
    
    @Override
    public void speak() {
        System.out.println("B say hello");
    }

    public void sleep() {
        System.out.println("B is sleeping");
    }
}
