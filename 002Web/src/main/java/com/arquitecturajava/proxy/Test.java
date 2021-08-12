package com.arquitecturajava.proxy;

public class Test {

    public static void main(String[] args) {
        MessageManager message = FactoryMessage.getMessage();
        message.send("Hello!");
        message.send("Goodbye!");
    }
}