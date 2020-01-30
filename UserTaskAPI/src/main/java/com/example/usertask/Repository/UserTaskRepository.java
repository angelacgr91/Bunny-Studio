package com.example.usertask.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.usertask.Model.UserTask;

@RepositoryRestResource
public interface UserTaskRepository extends CrudRepository<UserTask, Long> {
}
