package com.ambula.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ambula.api.entity.User;
import com.ambula.api.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create_data")
    public ResponseEntity<String> createTable(@RequestBody User user) {
	User user2 = userService.createUserTable(user);
        return ResponseEntity.ok("Table created successfully." +user2);
    }
	@PostMapping("/update_data")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok("User updated successfully.");
    }
	@GetMapping("/get_users/{N}")
    public ResponseEntity<List<User>> getNearestUsers(@PathVariable int N) {
        List<User> nearestUsers = userService.getNearestUsers(N);
        return ResponseEntity.ok(nearestUsers);
    }
	
}
