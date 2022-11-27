package com.app.smoothie.adapter.primary.rest.json;

import lombok.Getter;

@Getter
public class GeneralError
{
    private final String code;
    private final String message;

    public GeneralError(String code, String message)
    {
        this.code = code;
        this.message = message;
    }
}
