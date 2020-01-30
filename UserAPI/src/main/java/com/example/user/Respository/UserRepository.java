package com.example.user.Respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.user.Model.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
}
