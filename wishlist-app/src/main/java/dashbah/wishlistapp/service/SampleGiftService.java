package dashbah.wishlistapp.service;

import dashbah.wishlistapp.dto.SampleGiftDto;

import java.util.List;

public interface SampleGiftService {
    List<SampleGiftDto> findAll();

    SampleGiftDto findById(Long id);

    SampleGiftDto save(SampleGiftDto book);

    void deleteById(Long id);
}
