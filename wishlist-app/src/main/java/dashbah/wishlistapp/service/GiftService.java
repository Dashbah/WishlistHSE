package dashbah.wishlistapp.service;

import dashbah.wishlistapp.dto.GiftDTO;
import dashbah.wishlistapp.exception.GiftNotFoundException;
import dashbah.wishlistapp.exception.UserNotFoundException;
import dashbah.wishlistapp.exception.WrongUserAndGiftPairException;

import java.util.List;

public interface GiftService {

    public List<GiftDTO> getAllUserGifts(String username) throws UserNotFoundException;

    GiftDTO createNewGift(String username, GiftDTO gift) throws UserNotFoundException;

    GiftDTO getGiftByGiftUId(String giftUId) throws GiftNotFoundException;

    void deleteGift(String username, String giftUId) throws UserNotFoundException, GiftNotFoundException, WrongUserAndGiftPairException;
}
