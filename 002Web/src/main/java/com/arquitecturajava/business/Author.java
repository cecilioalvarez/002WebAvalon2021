package com.arquitecturajava.business;

public class Author {

    private String pk_id;
    private String name;
    private int age;

    public Author(String id, String name, int age) {
        this.pk_id = id;
        this.name = name;
        this.age = age;
    }

    public Author(String pk_id) {
        this.pk_id = pk_id;
    }

    public String getPk_id() {
        return this.pk_id;
    }

    public void setPk_id(String pk_id) {
        this.pk_id = pk_id;
    }

    public String getName() {
        return this.name;
    }

   public  void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + this.pk_id + "] " + this.name + " tiene " + this.age + " años.";
    }
}