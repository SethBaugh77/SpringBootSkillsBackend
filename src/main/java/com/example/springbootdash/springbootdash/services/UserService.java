package com.example.springbootdash.springbootdash.services;

import com.example.springbootdash.springbootdash.Entities.User;
import com.example.springbootdash.springbootdash.Exceptions.DuplicateEntryException;
import com.example.springbootdash.springbootdash.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

  public Iterable<User> getUsers(){
     return userRepository.findAll();
  }

  @Transactional
  public Optional<User> getUserById(int id){
        return userRepository.findById(id);
  }

  @Transactional
  public User insertUser(User user){
      Optional<User> user1 = getUserById(user.getUserId());
      if (user1.isPresent()) {
          throw new DuplicateEntryException("User already exists");
      }
       return userRepository.save(user);
  }


}
