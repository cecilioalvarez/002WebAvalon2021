package com.arquitecturajava.proxy;

public class StandardMessage implements MessageManager {

    @Override
    public void send(String content) {
        System.out.println("Contenido del mensaje: " + content);
    }
}