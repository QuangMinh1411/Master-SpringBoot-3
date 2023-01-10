package com.heaven.webservice.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int ct = 0;
    static {
        users.add(new User(++ct,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++ct,"Eve", LocalDate.now().minusYears(50)));
        users.add(new User(++ct,"John", LocalDate.now().minusYears(40)));

    }
    public List<User> findAll(){
        return users;
    }

    public User findById(Integer id) {
       return users.stream().filter(user -> user.getId()==id).findFirst().orElse(null);
    }

    public User saveUser(User user){
        user.setId(++ct);
        users.add(user);
        return user;
    }
    public void deleteUser(Integer id){
        users.removeIf(user -> user.getId()==id);
    }
}
