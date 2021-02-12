package com.scopemedia.api.dto;

/**
 * @author Maikel Rehl on 6/22/2017.
 */

public class ScopeAIMissingArgumentException extends IllegalArgumentException {
    public ScopeAIMissingArgumentException(String message) {
        super(message);
    }
}
