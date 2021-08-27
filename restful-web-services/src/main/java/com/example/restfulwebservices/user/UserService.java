package com.example.restfulwebservices.user;

import com.example.restfulwebservices.post.Post;
import com.example.restfulwebservices.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUserById(long id) {

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new UserNotFoundException("User not found with Id: "+id);
        }
        return user.get();
    }

    public User addUser(User user) {

        return  userRepository.save(user);
    }

    public void deleteUserById(long id) {

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new UserNotFoundException("User not found with Id: "+id);
        }


        userRepository.deleteById(id);

    }

    public List<Post> getPostsByUserId(long id) {

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new UserNotFoundException("User not found with id: "+id);
        }

        return user.get().getPosts();
    }

    public Post createPost(long id, Post post) {

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new UserNotFoundException("User not found with id: "+id);
        }

        post.setUser(user.get());

        return postRepository.save(post);

    }
}
