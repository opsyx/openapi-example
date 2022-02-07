package com.opsyx.openapi.sample.services;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean isAuthorized() {
        return true;
    }

}
