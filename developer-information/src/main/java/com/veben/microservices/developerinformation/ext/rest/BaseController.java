package com.veben.microservices.developerinformation.ext.rest;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public abstract class BaseController {

    static final String BASE_URI = "/api/developer-information/v1";
}
