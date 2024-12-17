package dashbah.wishlistapp.mapping;

import dashbah.wishlistapp.dto.SampleGiftDto;
import dashbah.wishlistapp.entity.SampleGiftEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SampleGiftMapper {
    SampleGiftEntity dtoToModel(SampleGiftDto sampleGiftDto);
    SampleGiftDto modelToDto(SampleGiftEntity sampleGiftEntity);
    List<SampleGiftDto> toListDto(List<SampleGiftEntity> sampleGiftEntities);
}
