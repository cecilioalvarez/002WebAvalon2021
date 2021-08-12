package com.arquitecturajava.proxy;

public class FactoryMessage {

    public static MessageManager getMessage() {
        return new MessageManagerProxy(new StandardMessage());
    }
}