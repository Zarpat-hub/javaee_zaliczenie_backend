package com.example.javaee_project.controllers;

import com.example.javaee_project.models.AppUser;
import com.example.javaee_project.models.DTO.LoginDTO;
import com.example.javaee_project.services.IAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authenticate")
@CrossOrigin("http://localhost:5173")
public class AuthenticateController {

    private final IAppUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        AppUser user = userService.getAppUser(loginDTO.getUsername());
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        if(!user.getPassword().equals(loginDTO.getPassword())) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(loginDTO);
    }
}
