package softuni.mobilele.mobilele.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.mobilele.mobilele.model.entities.UserEntity;
import softuni.mobilele.mobilele.repository.UserRepository;
import softuni.mobilele.mobilele.security.CurrentUser;
import softuni.mobilele.mobilele.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           UserRepository userRepository,
                           CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String userName, String password) {
        Optional<UserEntity> userEntityOpt = userRepository.findByUsername(userName);

        if (userEntityOpt.isEmpty()) {
            return false;
        } else {
            return passwordEncoder.matches(password, userEntityOpt.get().getPassword());
        }
    }

    @Override
    public void loginUser(String userName) {
        currentUser.
                setAnonymous(false).
                setName(userName);
    }
}

