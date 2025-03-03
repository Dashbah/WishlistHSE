package dashbah.wishlistapp.repository;

import dashbah.wishlistapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity getByUsername(String username);
}
