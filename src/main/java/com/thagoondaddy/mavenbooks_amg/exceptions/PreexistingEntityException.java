package com.thagoondaddy.mavenbooks_amg.exceptions;

/**
 *
 * Custom generated exception that will be thrown if the 
 * entity attempted to be created already exists. helps identify
 * specific problems.
 * 
 * @author Andy
 */
public class PreexistingEntityException extends Exception {
    /**
     *
     * @param message
     * @param cause
     */
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    /**
     *
     * @param message
     */
    public PreexistingEntityException(String message) {
        super(message);
    }
}
