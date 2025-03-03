package dashbah.wishlistapp.dto;

import io.micrometer.common.lang.Nullable;
import lombok.Data;

@Data
public class SampleGiftDto {
    @Nullable
    private String giftId;
    private String title;
    private String description;
    private long price;
    private String url;
}
