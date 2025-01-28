package dashbah.wishlistapp.service.impl;

import dashbah.wishlistapp.dto.SampleGiftDto;
import dashbah.wishlistapp.entity.SampleGiftEntity;
import dashbah.wishlistapp.mapping.SampleGiftMapper;
import dashbah.wishlistapp.repository.SampleGiftRepository;
import dashbah.wishlistapp.service.SampleGiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SampleGiftServiceImpl implements SampleGiftService {

    private final SampleGiftRepository bookRepository;
    private final SampleGiftMapper bookMapper;

    @Override
    public List<SampleGiftDto> findAll() {
        return bookMapper.toListDto(bookRepository.findAll());
    }

    @Override
    public SampleGiftDto findById(Long id) throws NullPointerException {
        return Optional.of(getById(id)).map(bookMapper::modelToDto).get();
    }

    @Override
    @Transactional
    public SampleGiftDto save(SampleGiftDto book) {
        return bookMapper.modelToDto(bookRepository.save(
                bookMapper.dtoToModel(book)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        var book = getById(id);
        bookRepository.delete(book);
    }

    private SampleGiftEntity getById(Long id) throws NullPointerException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(
                        "SampleGift with id: " + id + " not found"));
    }
}
