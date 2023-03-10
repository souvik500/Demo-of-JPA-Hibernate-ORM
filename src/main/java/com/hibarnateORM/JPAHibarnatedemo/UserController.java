package com.hibarnateORM.JPAHibarnatedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController
{
    @Autowired
    UserService userService;

    @PostMapping("addUser")
    public ResponseEntity<String> addUser (@RequestBody User user)
    {
        userService.addUser (user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("getAllUser")
    public ResponseEntity<List<User>> getAllUserDetails ()
    {
//        userService.getAllUser();
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("getUserById/")
    public ResponseEntity<User> getUserById(@RequestParam("id") int userId)
    {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("deleteByRollNo/")
    public ResponseEntity<String> deleteByRollNo (@RequestParam("id") int rollNo)
    {
        userService.deleteByRollNo(rollNo);
        return new ResponseEntity<>(rollNo + " deleted Successfully", HttpStatus.OK);
    }

    @DeleteMapping("deleteUser/")
    public ResponseEntity<String> deleteUser ()
    {
        userService.deleteUser();
        return new ResponseEntity<>("deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("UpdateUserId")
    public ResponseEntity<String> UpdateUserId (@RequestParam("id") int rollNo)
    {
        userService.updateUserId(rollNo);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
