package com.heaven.webservice.service;

import com.heaven.webservice.repository.UserRepository;
import com.heaven.webservice.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }
    public List<User> findAll(){
        return repo.findAll();
    }
    public User findOne(Integer id){
        return repo.findById(id).orElse(null);
    }

    public User saveUser(User user){
        return repo.save(user);
    }
    public void deleteUser(Integer id){
        repo.deleteById(id);
    }
}
