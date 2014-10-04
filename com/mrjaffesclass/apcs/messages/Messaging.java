package com.mrjaffesclass.apcs.messages;

import java.util.*;

/**
 * Implements messaging between controllers
 * 
 * @author Roger Jaffe
 * @version 2014-09-30
 */

public class Messaging
{
    // Keeps our message list
    private List<MessageObject> messageList = new ArrayList<MessageObject>();

    /**
     * Constructor for the messaging system
     */
    public Messaging() {
        
    }

    /**
     * Finds the controller list for a specified message name
     * 
     * @param messageName Name of message we're looking for
     * @return The MessageObject if found, or null otherwise
     */
    private MessageObject findMessage(String messageName) {
        MessageObject found = null;
        
        for (MessageObject m : messageList) {
            if ((found == null) && messageName.equals(m.getMessageName())) {
                found = m;
            }
        }
        return found;
    }

    /**
     * Subscribe an object so its notify method fires when the message is sent
     * 
     * @param messageName Name of the message
     * @param mc The object that is notified when messageName is published
     */
    public void subscribe(String messageName, MessageMailbox mc) {
        // See if we already have this message in the list
        MessageObject mo = findMessage(messageName);
        
        // If the message was found...
        if (mo != null) {
            // Add it to the list
            mo.addObject(mc);
        } else {
            // Otherwise make a new MessageObject, add the controller to it, then add
            // the new MessageObject to the message objects in our list
            MessageObject newMessage = new MessageObject(messageName);
            newMessage.addObject(mc);
            messageList.add(newMessage);
        }
    }
    
    /**
     * Call to send a message with no data to the controllers that have subscribed
     * 
     * @param messageName Name of the message to send
     * @return True if MessageObject was found
     */
    public boolean notify(String messageName) {
        return notify(messageName, null);
    }
    
    /**
     * Call to send a message to the controllers that have subscribed
     * 
     * @param messageName Name of the message to send
     * @param data Data sent with the message.  
     * @return True if MessageObject was found
     */
    public boolean notify(String messageName, Object data) {
        MessageObject mo = findMessage(messageName);
        if (mo != null) {
            mo.notify(data);
        }
        return (mo != null);
    }
    
    /**
     * Call to send a message to the controllers that have subscribed
     * and log the message and data if present to the console when debug is true
     * 
     * @param messageName Name of the message to send
     * @param data Data sent with the message.  
     * @param debug Set true for log messages to console
     * @return True if MessageObject was found
     */
    public boolean notify(String messageName, Object data, boolean debug) {
        if (debug) {
            if (data != null) {
                System.out.println("MSG: "+messageName+" | "+data.toString());
            } else {
                System.out.println("MSG: "+messageName+" | no data sent");
            }
        }
        MessageObject mo = findMessage(messageName);
        if (mo != null) {
            mo.notify(data);
        }
        return (mo != null);
    }
}
