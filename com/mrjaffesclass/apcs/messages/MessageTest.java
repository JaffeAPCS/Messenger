package com.mrjaffesclass.apcs.messages;


/**
 * Write a description of class MessageTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MessageTest
{
    // instance variables - replace the example below with your own
    private TestController c1 = new TestController(0);
    private TestController c2 = new TestController(1);
    private TestController c3 = new TestController(2);
    private Messages m = new Messages();
    /**
     * Constructor for objects of class MessageTest
     */
    public MessageTest()
    {
        m.subscribe("Message1", c1);
        m.subscribe("Message1", c2);
        m.subscribe("Message1", c3);
        
        m.subscribe("Message2", c1);
        m.subscribe("Message2", c2);
        
        m.subscribe("Message3", c2);
        m.subscribe("Message3", c3);
        
        m.subscribe("Message4", c3);        
    }
    
    public void sendMessage1() {
        m.notify("Message1");
    }

    public void sendMessage2() {
        m.notify("Message2");
    }
    
    public void sendMessage3() {
        m.notify("Message3");
    }

    public void sendMessage4() {
        m.notify("Message4");
    }
    
    public void setMessageWithData() {
        MessageData d = new MessageData();
        d.setData("key1","key1Data");
        d.setData("key2","key2Data");
        m.notify("Message2", d);
    }

}
