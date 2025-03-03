package dashbah.wishlistapp.repository;

import dashbah.wishlistapp.entity.GiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<GiftEntity, Long> {

    public GiftEntity findByGiftUId(String giftUId);
}
