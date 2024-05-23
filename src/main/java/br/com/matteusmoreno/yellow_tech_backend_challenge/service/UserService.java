package br.com.matteusmoreno.yellow_tech_backend_challenge.service;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.User;
import br.com.matteusmoreno.yellow_tech_backend_challenge.repository.UserRepository;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.CreateUserRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(CreateUserRequest request) {
        User user = new User();

        BeanUtils.copyProperties(request, user);

        userRepository.save(user);

        return user;
    }

    public User userDetails(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
