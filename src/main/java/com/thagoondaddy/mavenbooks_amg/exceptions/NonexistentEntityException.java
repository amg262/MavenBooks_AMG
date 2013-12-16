package com.thagoondaddy.mavenbooks_amg.exceptions;

/**
 *
 * Custom generated exception that will be thrown if the entity
 * trying to be CRUD'd is not existent. Helps identify problems
 * with JPA if thrown.
 * 
 * @author Andy
 */
public class NonexistentEntityException extends Exception {
    /**
     *
     * @param message
     * @param cause
     */
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    /**
     *
     * @param message
     */
    public NonexistentEntityException(String message) {
        super(message);
    }
}
