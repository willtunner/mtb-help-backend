package com.helpdesk.mtb.help_mtb.service;

import com.helpdesk.mtb.help_mtb.model.User;
import jakarta.mail.MessagingException;

import java.util.List;

public interface UserServiceInterface {
    User createUser(User user) throws MessagingException;
    Boolean deleteUser(Long idUser);
    List<User> getUsers(String name);
    List<User>getAllUsers();
    User getUserById(Long idUser);
}
