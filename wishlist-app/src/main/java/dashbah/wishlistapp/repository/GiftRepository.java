package dashbah.wishlistapp.repository;

import dashbah.wishlistapp.entity.GiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GiftRepository extends JpaRepository<GiftEntity, Long> {

    Optional<GiftEntity> findByGiftUId(String giftUId);
}
