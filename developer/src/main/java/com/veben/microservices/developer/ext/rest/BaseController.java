package com.veben.microservices.developer.ext.rest;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public abstract class BaseController {
    private BaseController() {}

    static final String BASE_URI = "/api/developer/v1";
}
