package com.app.smoothie.core.sharedkernel.exception;

import lombok.Getter;

@Getter
public class SmoothieApplicationException extends RuntimeException
{
    private final String code;

    public SmoothieApplicationException(String code, String message)
    {
        super(message);
        this.code = code;
    }
}
