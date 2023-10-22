package dev.andreyrocha.santanderdevweek2023.service;

import dev.andreyrocha.santanderdevweek2023.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}