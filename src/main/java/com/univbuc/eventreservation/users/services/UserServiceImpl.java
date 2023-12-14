package com.univbuc.eventreservation.users.services;

import com.univbuc.eventreservation.users.model.User;
import com.univbuc.eventreservation.users.model.UserResponse;
import com.univbuc.eventreservation.users.repositories.UserRepository;
import com.univbuc.eventreservation.users.repositories.UserRepositoryJPA;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserResponse login(User user) {
        User storedUser = userRepository.findByUserName(user.getUserName());
        if (user.getPassword().equals(storedUser.getPassword())){
            return new UserResponse();
        }
        return null;
    }
}
