package org.afrivera.springcloud.msvc.users.controller;

import org.afrivera.springcloud.msvc.users.dto.RequestUserDto;
import org.afrivera.springcloud.msvc.users.dto.ResponseUserDto;
import org.afrivera.springcloud.msvc.users.model.entity.UserEntity;
import org.afrivera.springcloud.msvc.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseUserDto>> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseUserDto> saveUser(@RequestBody RequestUserDto user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id){
        boolean user = userService.destroy(id);
        if(user){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
