package com.bloggingappapis.repositories;

import com.bloggingappapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    // this will provide functionalities like find, paging sorting, delete, get by id and so many
    // we can create custom finder methods

}
