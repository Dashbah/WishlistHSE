package dashbah.wishlistapp.repository;

import dashbah.wishlistapp.entity.SampleGiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleGiftRepository extends JpaRepository<SampleGiftEntity, Long> {
    SampleGiftEntity getSampleGiftEntityByTitleContains(String titlePart);
}
