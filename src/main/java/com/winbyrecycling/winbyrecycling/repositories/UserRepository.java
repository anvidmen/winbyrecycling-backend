package com.winbyrecycling.winbyrecycling.repositories;

import com.winbyrecycling.winbyrecycling.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

