package dashbah.wishlistapp.service.impl;

import dashbah.wishlistapp.dto.GiftDTO;
import dashbah.wishlistapp.entity.UserEntity;
import dashbah.wishlistapp.exception.GiftNotFoundException;
import dashbah.wishlistapp.exception.UserNotFoundException;
import dashbah.wishlistapp.exception.WrongUserAndGiftPairException;
import dashbah.wishlistapp.mapping.GiftMapper;
import dashbah.wishlistapp.repository.wrapper.GiftRepositoryWrapper;
import dashbah.wishlistapp.repository.wrapper.UserRepositoryWrapper;
import dashbah.wishlistapp.service.GiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static dashbah.wishlistapp.util.Util.generateUid;

@Service
@RequiredArgsConstructor
@Slf4j
public class GiftServiceImpl implements GiftService {

    private final GiftRepositoryWrapper giftRepositoryWrapper;
    private final UserRepositoryWrapper userRepositoryWrapper;
    private final GiftMapper giftMapper;

    @Override
    public List<GiftDTO> getAllUserGifts(String username) throws UserNotFoundException {
        UserEntity user = userRepositoryWrapper.findUserByUserName(username);
        var gifts = user.getGifts();
        return giftMapper.toListDto(gifts);
    }

    @Override
    public GiftDTO createNewGift(String username, GiftDTO gift) throws UserNotFoundException {
        String giftUId = generateUid();
        gift.setGiftUId(giftUId);
        var giftEntity = giftMapper.dtoToModel(gift);
        var user = userRepositoryWrapper.findUserByUserName(username);
        user.addGift(giftEntity);

        /// TODO: move to test
        try {
            giftRepositoryWrapper.findGiftByGiftUId(giftUId);
            log.info("Gift created successfully: {}", giftEntity.getGiftUId());
        } catch (GiftNotFoundException e) {
            log.warn("Gift was not created: {}", giftEntity.getGiftUId());
        }

        return gift;
    }

    @Override
    public GiftDTO getGiftByGiftUId(String giftUId) throws GiftNotFoundException {
        var gift = giftRepositoryWrapper.findGiftByGiftUId(giftUId);
        return giftMapper.modelToDto(gift);
    }

    @Override
    public void deleteGift(String username, String giftUId) throws UserNotFoundException, GiftNotFoundException, WrongUserAndGiftPairException {
        var user = userRepositoryWrapper.findUserByUserName(username);
        var gift = giftRepositoryWrapper.findGiftByGiftUId(giftUId);
        if (!user.getGifts().contains(gift)) {
            throw new WrongUserAndGiftPairException();
        }

        // TODO: test it
        user.getGifts().remove(gift);
        giftRepositoryWrapper.deleteGift(gift);

        log.info("gift deleted with giftUId = " + giftUId);
    }
}
