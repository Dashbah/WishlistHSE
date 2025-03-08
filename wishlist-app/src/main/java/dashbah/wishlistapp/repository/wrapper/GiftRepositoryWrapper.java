package dashbah.wishlistapp.repository.wrapper;

import dashbah.wishlistapp.entity.GiftEntity;
import dashbah.wishlistapp.exception.GiftNotFoundException;
import dashbah.wishlistapp.repository.GiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GiftRepositoryWrapper {
    private final GiftRepository giftRepository;

    public GiftEntity findGiftByGiftUId(String giftUId) throws GiftNotFoundException {
        return giftRepository.findByGiftUId(giftUId).orElseThrow(() -> new GiftNotFoundException(giftUId));
    }

    public void deleteGift(GiftEntity giftEntity) {
        giftRepository.delete(giftEntity);
    }
}
