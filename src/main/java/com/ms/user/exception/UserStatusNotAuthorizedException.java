package com.ms.user.exception;

public class UserStatusNotAuthorizedException extends  RuntimeException{
    public UserStatusNotAuthorizedException(String s){
        super(s);
    }
}
