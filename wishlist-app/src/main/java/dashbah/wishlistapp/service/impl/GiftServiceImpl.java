package dashbah.wishlistapp.service.impl;

import dashbah.wishlistapp.dto.GiftDTO;
import dashbah.wishlistapp.entity.UserEntity;
import dashbah.wishlistapp.exception.GiftNotFoundException;
import dashbah.wishlistapp.exception.UserNotFoundException;
import dashbah.wishlistapp.mapping.GiftMapper;
import dashbah.wishlistapp.repository.GiftRepository;
import dashbah.wishlistapp.repository.UserRepository;
import dashbah.wishlistapp.service.GiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class GiftServiceImpl implements GiftService {

    private final GiftRepository giftRepository;
    private final UserRepository userRepository;
    private final GiftMapper giftMapper;

    @Override
    public List<GiftDTO> getAllUserGifts(String username) throws UserNotFoundException {
        dashbah.wishlistapp.entity.UserEntity user = findUser(username);
        var gifts = user.getGifts();
        return giftMapper.toListDto(gifts);
    }

    @Override
    public GiftDTO createNewGift(String username, GiftDTO gift) throws UserNotFoundException {
        String giftUId = generateUid();
        gift.setGiftUId(giftUId);
        var giftEntity = giftMapper.dtoToModel(gift);
        var user = findUser(username);
        user.addGift(giftEntity);

        /// for checking
        if (giftRepository.findByGiftUId(giftUId) != null) {
            log.info("Gift created successfully: {}", giftEntity.getGiftUId());
        } else {
            log.warn("Gift was not created: {}", giftEntity.getGiftUId());
        }
        return gift;
    }

    @Override
    public GiftDTO getGiftByGiftUId(String giftUId) throws GiftNotFoundException {
        var gift = giftRepository.findByGiftUId(giftUId);
        if (gift == null) {
            throw new GiftNotFoundException(giftUId);
        }
        return giftMapper.modelToDto(gift);
    }

    private String generateUid() {
        Random rnd = new Random();
        return "randomized" + rnd.nextInt(100000, 800000);
    }

    private UserEntity findUser(String username) throws UserNotFoundException {
        var user = userRepository.getByUsername(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        }
        return user;
    }
}
