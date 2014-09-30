package com.mrjaffesclass.apcs.messages;


/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestController implements MessageController
{
    private int number;
    
    public TestController(int aNumber) {
        number = aNumber;
    }
    
    public void notify(String messageName, MessageData messageData) {
        System.out.println("Controller "+number+' '+messageName);
        if (messageData != null) {
            System.out.println("key1 "+messageData.getData("key1"));
            System.out.println("key2 "+messageData.getData("key2"));
            System.out.println("key3 "+messageData.getData("key3","Key does not exist"));
        }
    }
}
