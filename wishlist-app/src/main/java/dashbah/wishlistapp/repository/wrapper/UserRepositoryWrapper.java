package dashbah.wishlistapp.repository.wrapper;

import dashbah.wishlistapp.entity.UserEntity;
import dashbah.wishlistapp.exception.UserNotFoundException;
import dashbah.wishlistapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserRepositoryWrapper {
    private final UserRepository userRepository;

    public UserEntity findUserByUserName(String username) throws UserNotFoundException {
        return userRepository.getByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }
}
