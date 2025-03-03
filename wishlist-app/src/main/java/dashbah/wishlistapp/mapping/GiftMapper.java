package dashbah.wishlistapp.mapping;

import dashbah.wishlistapp.dto.GiftDTO;
import dashbah.wishlistapp.entity.GiftEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GiftMapper {
    GiftEntity dtoToModel(GiftDTO giftDto);
    GiftDTO modelToDto(GiftEntity giftEntity);
    List<GiftDTO> toListDto(List<GiftEntity> giftEntities);
}
