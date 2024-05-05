package com.we_hack.smart_order_managment_system.exceptions;

public class FileUploadException extends SpringBootFileUploadException{

    public FileUploadException(String message) {
        super(message);
    }
}