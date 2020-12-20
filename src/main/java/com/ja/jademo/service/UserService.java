package com.ja.jademo.service;


import com.ja.jademo.model.Role;
import com.ja.jademo.model.User;
import com.ja.jademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        List<User> list = userRepository.findAll();
        return list;
    }

    public User getOne(Long id) {
        return userRepository.getOne(id);
    }

    public User save(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        Role role = new Role();
        role.setId(1l);
        user.getRoles().add(role);
        return userRepository.save(user);
    }

    public void deleteOne(Long id) {
        userRepository.deleteById(id);
    }


}
