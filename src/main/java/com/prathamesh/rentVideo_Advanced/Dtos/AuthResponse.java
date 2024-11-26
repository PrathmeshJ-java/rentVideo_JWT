package com.prathamesh.rentVideo_Advanced.Dtos;

public class AuthResponse {

    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public AuthResponse(String token) {
        this.token = token;
    }
}
