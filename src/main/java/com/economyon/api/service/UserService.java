package com.economyon.api.service;

import com.economyon.api.exception.BadRequestException;
import com.economyon.api.model.User;
import com.economyon.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByIdOrThrowBadRequestException(long id) {
        return userRepository.findById(id).orElseThrow(() -> new BadRequestException("User not Found"));
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(User user) {
        User savedUser = findByIdOrThrowBadRequestException(user.getId());
        user.setId(savedUser.getId());
        userRepository.save(user);
    }
}
