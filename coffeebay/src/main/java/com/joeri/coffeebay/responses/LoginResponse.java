package com.joeri.coffeebay.responses;

public class LoginResponse {
    private boolean isSuccess;
    private String JWT;

    public boolean getIsSucces(){ return isSuccess;}
    public void setIsSucces(boolean isSuccess){ this.isSuccess = isSuccess;}

    //public String getJWT();
}
