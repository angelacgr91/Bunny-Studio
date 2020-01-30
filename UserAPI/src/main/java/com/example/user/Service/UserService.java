package com.example.user.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.Model.User;
import com.example.user.Respository.UserRepository;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        Iterable<User> list = userRepository.findAll();

        ArrayList<User> users = new ArrayList<User>();
        list.forEach(e -> users.add(e));

        return users;
    }

	public User findById(Long userId) {
		
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.get();
		
		return user;
	}

	public User saveUser(User user) {
		
		return userRepository.save(user);
	}


	public void deleteUser(User user) {
		
		userRepository.delete(user);
		
	}

}
