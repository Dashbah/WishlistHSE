package dashbah.wishlistapp.service;

import dashbah.wishlistapp.dto.SampleGiftDto;

import java.util.List;

public interface SampleGiftService {
    List<SampleGiftDto> findAll();

    SampleGiftDto findByTitle(String title);

    SampleGiftDto save(SampleGiftDto book);

    void deleteById(Long id);
}
