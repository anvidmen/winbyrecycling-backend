package com.winbyrecycling.winbyrecycling.services;

import java.util.List;
import com.winbyrecycling.winbyrecycling.models.User;

public interface UserService {
   User saveUser(User user);
   User getUser(String username);
   List<User>getUsers();
}