package com.example.restfulwebservices.user;

import com.example.restfulwebservices.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Get /users
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUserById(@PathVariable long id) {

        User user = userService.getUserById(id);
        EntityModel<User> model = EntityModel.of(user);

        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).getAllUsers());
        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
        User savedUser = userService.addUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return  ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable long id){

        userService.deleteUserById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable long id){
        return userService.getPostsByUserId(id);
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable long id, @RequestBody Post post){
        Post savedPost = userService.createPost(id,post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

//    @GetMapping("/users/{id}/posts/{postId}")
//    public Post getPostBy(@PathVariable long id, @RequestBody Post post){
//        Post savedPost = userService.createPost(id,post);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
//        return ResponseEntity.created(location).build();
//    }
}
