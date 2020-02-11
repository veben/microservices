package com.veben.microservices.developer.ext.rest;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Api(value = "developer")
public abstract class BaseController {

    static final String BASE_URI = "/api/developer/v1";
}
