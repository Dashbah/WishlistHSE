package dashbah.wishlistapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {
    private String username;
    private String email;
    private String password;
    // Геттеры и сеттеры
}
