package com.camping.dev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/logout")
public class LogoutController {

    private final Logger logger = LoggerFactory.getLogger("LogoutController's Log");

    @GetMapping
    public void memberLogout(HttpSession session) {

        session.invalidate();

    }

}
