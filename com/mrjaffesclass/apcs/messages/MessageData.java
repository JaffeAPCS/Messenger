package com.mrjaffesclass.apcs.messages;
import java.util.*;

/**
 * Implement this class to send data with the messages
 * 
 * @author Roger Jaffe
 * @version 1.0
 */
public class MessageData
{
    private Properties properties = new Properties();
 
    /**
     * Constructor
     */
    public MessageData() {

    }

    /**
     * Get a value from the packet sent with the message
     * @param key Parameter key
     * @return Value that goes with the key
     *  See http://www.tutorialspoint.com/java/java_properties_class.htm for more information
     */
    public String getData(String key) {
        return properties.getProperty(key);
    }
    
    /**
     * Get a value from the packet sent with the message
     * @param key Parameter key
     * @param defaultValue
     * @return Value that goes with the key. If key doesn't exist, then return default value
     */
    public String getData(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    /**
     * Get the entire Properties data from the message
     * @return Properties variable
     */
    public Properties getProperties() {
        return properties;
    }
    
    /**
     * Set a key->value pair to be sent with the message
     */
    public void setData(String key, String value) {
        properties.setProperty(key, value);
    }
}
