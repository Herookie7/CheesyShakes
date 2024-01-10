package com.herookie.employee.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herookie.employee.dto.UserDTO;
import com.herookie.employee.entities.Role;
import com.herookie.employee.entities.User;
import com.herookie.employee.exceptions.EntityNotFoundException;
import com.herookie.employee.exceptions.UnsavedEntityException;
import com.herookie.employee.services.IUserService;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @PostMapping("/customer")
    public ResponseEntity<UserDTO> createCustomer(@RequestBody User user) throws UnsavedEntityException {
        user.setRole(Role.CUSTOMER);
        User createdUser = userService.createUser(user);
        UserDTO userDTO = convertToDTO(createdUser);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PostMapping("/admin")
    public ResponseEntity<UserDTO> createAdmin(@RequestBody User user) throws UnsavedEntityException {
        user.setRole(Role.ADMIN);
        User createdUser = userService.createUser(user);
        UserDTO userDTO = convertToDTO(createdUser);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PostMapping("/subadmin")
    public ResponseEntity<UserDTO> createSubAdmin(@RequestBody User user) throws UnsavedEntityException {
        user.setRole(Role.SUBADMIN);
        User createdUser = userService.createUser(user);
        UserDTO userDTO = convertToDTO(createdUser);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.findAll();
        List<UserDTO> userDTOs = users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setAddress(user.getAddress());
        userDTO.setContactPhone(user.getContactPhone());
        userDTO.setEmail(user.getEmail());
        userDTO.setFullName(user.getFullName());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) throws EntityNotFoundException {
        User user = userService.findById(id);
        UserDTO userDTO = convertToDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) throws UnsavedEntityException {
        User createdUser = userService.createUser(user);
        UserDTO userDTO = convertToDTO(createdUser);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody User user)
            throws EntityNotFoundException, UnsavedEntityException {
        user.setUserId(id);
        User updatedUser = userService.update(user);
        UserDTO userDTO = convertToDTO(updatedUser);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) throws EntityNotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}