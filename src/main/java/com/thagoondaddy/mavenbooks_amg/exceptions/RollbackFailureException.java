package com.thagoondaddy.mavenbooks_amg.exceptions;

/**
 *
 * Custom generated exception that is thrown if there is an error
 * in the a transaction rollback.
 * 
 * @author Andy
 */
public class RollbackFailureException extends Exception {
    /**
     *
     * @param message
     * @param cause
     */
    public RollbackFailureException(String message, Throwable cause) {
        super(message, cause);
    }
    /**
     *
     * @param message
     */
    public RollbackFailureException(String message) {
        super(message);
    }
}
