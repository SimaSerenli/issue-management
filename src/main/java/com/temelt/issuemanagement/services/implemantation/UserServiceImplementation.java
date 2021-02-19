package com.temelt.issuemanagement.services.implemantation;

import com.temelt.issuemanagement.entity.User;
import com.temelt.issuemanagement.repo.UserRepository;
import com.temelt.issuemanagement.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User save(User user) {
        if (user.getUserName()==null){
            throw new IllegalArgumentException("Username cannot be null");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
