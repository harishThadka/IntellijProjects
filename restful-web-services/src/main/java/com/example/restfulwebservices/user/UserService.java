package com.example.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUserById(long id) {

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            return new User();
        }
        return user.get();
    }

    public User addUser(User user) {

        return  userRepository.save(user);
    }
}
