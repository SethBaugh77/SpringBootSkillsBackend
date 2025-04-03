package com.example.springbootdash.springbootdash.repositories;

import com.example.springbootdash.springbootdash.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
