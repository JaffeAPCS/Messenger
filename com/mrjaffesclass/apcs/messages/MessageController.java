package com.mrjaffesclass.apcs.messages;

/**
 * Implement this interface for your controller class. You can subscribe your controller class
 * to the Messages class using the Messages.subscribe method.  Send messages to the controllers
 * who have subscribed using the Messages.notify method. Optional data can be passed with the
 * message implementing the MessageData class
 * 
 * @author Roger Jaffe
 * @version 2014-09-30
 */
public interface MessageController

{
    /**
     * Fired when a message is sent through the Messages class that this
     * controller has subscribed to.
    */
    public void messageHandler(String messageName, Object messagePayload);   
}
