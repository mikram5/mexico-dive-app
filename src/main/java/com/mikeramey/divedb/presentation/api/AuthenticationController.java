package com.mikeramey.divedb.presentation.api;

import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.protocol.http.AuthScheme;
import sun.tools.jstat.Token;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/{username}+{password}")
    public ApiToken getApiToken(@PathVariable String username, @PathVariable String password) {
        return authenticationService.getApiToken(username, password);
    }

}
