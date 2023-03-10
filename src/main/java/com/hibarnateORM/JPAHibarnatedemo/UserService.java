package com.hibarnateORM.JPAHibarnatedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public void addUser(User user)
    {
        userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId).get();
    }

    public void deleteByRollNo(int rollNo)
    {
        userRepository.deleteById(rollNo);
    }

    public void deleteUser()
    {
        userRepository.deleteAll();
    }

    public void updateUserId(int rollNo)
    {
        userRepository.findById(rollNo);
    }
}
