package dev.andreyrocha.santanderdevweek2023.service.impl;

import dev.andreyrocha.santanderdevweek2023.domain.model.User;

public interface UserServiceImpl {

    User findById(Long id);

    User create(User userToCreate);
}