package com.wor.demo.user.service;


public interface JwtService {

    String getToken(String key, Object value);

    Claims getClaims(String token);
}