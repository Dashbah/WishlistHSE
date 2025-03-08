package dashbah.wishlistapp.repository;

import dashbah.wishlistapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> getByUsername(String username);
}
