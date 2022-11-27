package com.app.smoothie.core.sharedkernel.exception;

public class SmoothieNotFoundException extends SmoothieApplicationException
{
    private static final String CODE = "folder_not_found";
    public SmoothieNotFoundException(String message)
    {
        super(CODE, message);
    }
}
