package com.veben.microservices.developerinformation.ext.rest;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Api(value = "developer-information")
public abstract class BaseController {

    static final String BASE_URI = "/api/developer-information/v1";
}
