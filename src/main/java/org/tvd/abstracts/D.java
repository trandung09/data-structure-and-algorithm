package org.tvd.abstracts;

public class D extends C {
    private String name;

    public D() {
        this.name = "D";
    }

    public D(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("D is eating");
    }

    public void setNamr(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
