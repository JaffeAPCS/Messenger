package com.mrjaffesclass.apcs.messages;

import java.util.*;

/**
 * Implements messaging between controllers
 * 
 * @author Roger Jaffe
 * @version 1.0
 */

public class Messages
{
    // Keeps our message list
    private List<MessageObject> messageList = new ArrayList<MessageObject>();

    /**
     * Constructor for the messaging system
     */
    public Messages() {
        
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
     * Subscribe a controller so its notify method fired when message is published
     * 
     * @param messageName Name of the message
     * @param mc The Controller that is notified when messageName is published
     */
    public void subscribe(String messageName, MessageController mc) {
        // See if we already have this message in the list
        MessageObject mo = findMessage(messageName);
        
        // If the message was found...
        if (mo != null) {
            // Add it to the list
            mo.addController(mc);
        } else {
            // Otherwise make a new MessageObject, add the controller to it, then add
            // the new MessageObject to the message objects in our list
            MessageObject newMessage = new MessageObject(messageName);
            newMessage.addController(mc);
            messageList.add(newMessage);
        }
    }
    
    /**
     * Call to send a message to the controllers that have subscribed
     * 
     * @param messageName Name of the message to send
     * @param data Data sent with the message.  
     * @return True if MessageObject was found
     */
    public boolean notify(String messageName, MessageData data) {
        MessageObject mo = findMessage(messageName);
        if (mo != null) {
            mo.notify(data);
        }
        return (mo != null);
    }
    
    public boolean notify(String messageName) {
        return notify(messageName, null);
    }
    
}
