package com.mikeramey.divedb.presentation.api;

import com.mikeramey.divedb.logic.model.ApiToken;
import com.mikeramey.divedb.logic.model.User;
import com.mikeramey.divedb.logic.service.TokenService;
import com.mikeramey.divedb.logic.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private TokenService tokenService;
    private UserService userService;

    @Autowired
    public AuthenticationController(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @GetMapping
    public ApiToken createApiToken(@RequestParam String username, @RequestParam String password) {
        User user = userService.getUserByUserName(username);

        if (user == null) {
            return null;
        }

        return tokenService.createApiToken(username, password);

    }

}
