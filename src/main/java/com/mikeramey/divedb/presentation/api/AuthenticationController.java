package com.mikeramey.divedb.presentation.api;

import com.mikeramey.divedb.logic.model.ApiToken;
import com.mikeramey.divedb.logic.model.User;
import com.mikeramey.divedb.logic.service.AuthenticationService;
import com.mikeramey.divedb.logic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private AuthenticationService authenticationService;
    private UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    private User getUserByUserNameAndPassword(@RequestParam String username, @RequestParam String password) {
        return userService.getUserByUserNameAndPassword(username, password);
    }

    @GetMapping
    public ApiToken getApiToken(@RequestParam String username, @RequestParam String password) {
        return authenticationService.createApiToken(username, password);

    }

}
