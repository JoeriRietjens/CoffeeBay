package com.joeri.coffeebay.responses;

public class AuthenticationResponse {
   
    private final String jwt;
    
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return this.jwt;
    }
}
