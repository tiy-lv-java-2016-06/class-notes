package com.theironyard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jeff on 7/25/16.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such user found")
public class UsernameNotFoundException extends RuntimeException{
}
