package com.project.pavani.exceptions;
/**
 * @author ayush.pandey
 */
public class EmailAlreadyUsedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmailAlreadyUsedException() {
        super("Email is already in use!");
    }

}
