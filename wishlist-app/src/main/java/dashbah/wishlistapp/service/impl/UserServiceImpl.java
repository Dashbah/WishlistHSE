package dashbah.wishlistapp.service.impl;

import dashbah.wishlistapp.dto.request.UserRegistrationRequest;
import dashbah.wishlistapp.entity.UserEntity;
import dashbah.wishlistapp.exception.UserNotFoundException;
import dashbah.wishlistapp.repository.wrapper.UserRepositoryWrapper;
import dashbah.wishlistapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepositoryWrapper userRepositoryWrapper;
    private final PasswordEncoder passwordEncoder;

    public UserEntity registerUser(UserRegistrationRequest registrationRequest) {
        UserEntity user = UserEntity.builder()
                .username(registrationRequest.getUsername())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .build();
        return userRepositoryWrapper.saveUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            return userRepositoryWrapper.findUserByUserName(username);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
