package org.maxwell.wrongcase.apidesign_22.apiresponse;

import lombok.Data;

@Data
public class APIResponse<T> {
    private boolean success;
    private T data;
    private int code;
    private String message;



}