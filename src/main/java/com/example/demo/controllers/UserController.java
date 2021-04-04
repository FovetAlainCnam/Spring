package com.example.demo.controllers;

import com.example.demo.controllers.proxy.ProxyAdminAccess;
import com.example.demo.models.User;
import com.example.demo.models.Video;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        super(userRepository);
    }

    @GetMapping("/{id}/videos")
    public List<Video> getUserVideos(@PathVariable Integer id) {
        return videoRepository.findByUserId(id);
    }

    @PostMapping("/admin")
    public User addAdminAccess(@RequestParam String username, @RequestParam String magicPassword) {
        User user = userRepository.findByUsername(username);
        ProxyAdminAccess proxyAdminAccess = new ProxyAdminAccess();
        proxyAdminAccess.adminAccess(magicPassword, user);
        return userRepository.save(user);
    }

    @PostMapping
    public User save(User user) {
        return (User) crudFactoryService.performService(user, userRepository, "create");
    }

}
