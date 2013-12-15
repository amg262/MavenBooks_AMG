package com.thagoondaddy.mavenbooks_amg.exceptions;

/**
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
