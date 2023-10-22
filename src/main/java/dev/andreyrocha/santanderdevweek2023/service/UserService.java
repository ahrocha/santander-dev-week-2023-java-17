package dev.andreyrocha.santanderdevweek2023.service;

import dev.andreyrocha.santanderdevweek2023.domain.model.User;
import dev.andreyrocha.santanderdevweek2023.domain.repository.UserRepository;
import dev.andreyrocha.santanderdevweek2023.service.UserService;
import dev.andreyrocha.santanderdevweek2023.service.impl.UserServiceImpl;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService implements UserServiceImpl {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}