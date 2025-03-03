package dashbah.wishlistapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiftDTO {
    private String giftUId;
    private String title;
    private String description;
    private double price;
    private String url;
}
