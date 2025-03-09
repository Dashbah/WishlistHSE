package dashbah.wishlistapp.service;

import dashbah.wishlistapp.dto.request.UserRegistrationRequest;
import dashbah.wishlistapp.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public UserEntity registerUser(UserRegistrationRequest userRegistrationRequest);
}
