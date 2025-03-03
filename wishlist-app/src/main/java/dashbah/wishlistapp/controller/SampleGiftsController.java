package dashbah.wishlistapp.controller;

import dashbah.wishlistapp.dto.SampleGiftDto;
import dashbah.wishlistapp.service.SampleGiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
public class SampleGiftsController {

    private final SampleGiftService sampleGiftService;

    @GetMapping("/sampleGifts")
    public List<SampleGiftDto> allSampleGifts() {
        log.info("Получен запрос на получение списка подарков");
        return sampleGiftService.findAll();
    }

    @GetMapping("/sampleGift")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SampleGiftDto> getSampleGift(@RequestParam(name = "title") String title) {
        log.info(String.format("Принят запрос на получение подарка c title = %s", title));
        try {
            SampleGiftDto gift = sampleGiftService.findByTitle(title);
            log.info(String.format("Запрос на получение подарка c id = %s обработан успешно", title));
            return ResponseEntity.ok().body(gift);
        } catch (NullPointerException ex) {
            log.warn(String.format("Не найден подарок с id = %s", title));
            return ResponseEntity.notFound().build();
        } catch (Exception exception) {
            log.error(String.format("Произошла ошибка при попытке получения подарка с id = %s", title), (Object) exception.getStackTrace());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/sampleGift")
    public ResponseEntity<SampleGiftDto> createSampleGift(@RequestBody SampleGiftDto sampleGift) throws URISyntaxException {
        SampleGiftDto result = sampleGiftService.save(sampleGift);
        log.info("created new gift", result);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/sampleGift/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SampleGiftDto> updateSampleGift(@PathVariable Long id, @RequestBody SampleGiftDto sampleGift) {
        return ResponseEntity.ok().body(sampleGiftService.save(sampleGift));
    }

    @DeleteMapping("/sampleGift/{id}")
    public ResponseEntity<?> deleteSampleGift(@PathVariable Long id) {
        sampleGiftService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
