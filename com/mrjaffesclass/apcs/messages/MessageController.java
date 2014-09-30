package com.mrjaffesclass.apcs.messages;

/**
 * Implement this interface for your controller class. You can subscribe your controller class
 * to the Messages class using the Messages.subscribe method.  Send messages to the controllers
 * who have subscribed using the Messages.notify method. Optional data can be passed with the
 * message implementing the MessageData class
 * 
 * @author Roger Jaffe
 * @version 1.0
 */
public interface MessageController

{
    public void notify(String messageName, MessageData messageData);   
}
