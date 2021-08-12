package com.arquitecturajava.proxy;

public class MessageManagerProxy implements MessageManager {
    
    private MessageManager messageManager;

    public MessageManagerProxy(MessageManager message) {
        this.messageManager = message;
    }

    @Override
    public void send(String content) {
        System.out.println("Dispuesto a enviar el mensaje.");
        this.messageManager.send(content);
        System.out.println("Mensaje enviado.");
    }
}