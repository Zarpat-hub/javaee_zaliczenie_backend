package com.example.javaee_project.controllers;

import com.example.javaee_project.models.AppUser;
import com.example.javaee_project.services.IAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:5173")
public class AppUserController {
    private final IAppUserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok(userService.getAppUsers());
    }

    @PostMapping("/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        return ResponseEntity.ok((userService.saveAppUser(user)));
    }
    @GetMapping("/details")
    public ResponseEntity<AppUser> getUser(@RequestHeader String username)
    {
        return ResponseEntity.ok((userService.getAppUser(username)));
    }
}
