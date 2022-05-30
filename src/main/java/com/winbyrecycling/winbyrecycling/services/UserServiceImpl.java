package com.winbyrecycling.winbyrecycling.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.winbyrecycling.winbyrecycling.models.User;
import com.winbyrecycling.winbyrecycling.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
   @Autowired
   UserRepository userRepository;
   
   @Autowired
   private PasswordEncoder passwordEncoder;
 

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepository.findByUsername(username);
      if(user == null){
         //logger.error("User no found in the database");
         throw new UsernameNotFoundException("User no found in the database");
      }
      Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
   
      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
   }
 
   @Override
   public User saveUser(User user) {
      String plainPassword = user.getPassword();
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      User newUser = userRepository.save(user);
      newUser.setPassword(plainPassword);
      return newUser;
   }

   @Override
   public User getUser(String username) {
      return userRepository.findByUsername(username);
   }

   @Override
   public List<User> getUsers() {
      return (List<User>) userRepository.findAll();
   }
}
