package com.helpdesk.mtb.help_mtb.controllers;

import com.helpdesk.mtb.help_mtb.model.User;
import com.helpdesk.mtb.help_mtb.service.UserService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) throws MessagingException {
        return userService.createUser(user);
    }
}
