package dashbah.wishlistapp.dto.request;

import dashbah.wishlistapp.dto.GiftDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostGiftRq {
    private String rqUid;
    private GiftDTO gift;
}
