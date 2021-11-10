package com.joeri.coffeebay.responses;

public class AuthenticationRequest {
    private String username;
    private String password;

    public AuthenticationRequest() {
        super();
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
}