package com.thagoondaddy.mavenbooks_amg.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Custom generated exception for IllegalOrphan instances. Customized helps
 * understand where problem could lie in JPA/JSF
 * 
 * @author Andy
 */
public class IllegalOrphanException extends Exception {
    private List<String> messages;
    /**
     *
     * @param messages
     */
    public IllegalOrphanException(List<String> messages) {
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<String>();
        }
        else {
            this.messages = messages;
        }
    }
    /**
     * 
     * Method that returns messages variable
     *
     * @return messages
     */
    public List<String> getMessages() {
        return messages;
    }
}
