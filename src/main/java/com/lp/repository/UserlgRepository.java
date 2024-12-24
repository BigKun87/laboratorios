package com.lp.repository;

import com.lp.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserlgRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
