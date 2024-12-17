package dashbah.wishlistapp.controller;

import dashbah.wishlistapp.dto.SampleGiftDto;
import dashbah.wishlistapp.service.SampleGiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class SampleGiftsController {

    private final SampleGiftService sampleGiftService;

    @GetMapping("/sampleGifts")
    public List<SampleGiftDto> allSampleGifts() {
        return sampleGiftService.findAll();
    }

    @GetMapping("/sampleGift/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SampleGiftDto> getSampleGift(@PathVariable Long id) {
        return ResponseEntity.ok().body(sampleGiftService.findById(id));
    }

    @PostMapping("/sampleGift")
    public ResponseEntity<SampleGiftDto> createSampleGift(@RequestBody SampleGiftDto sampleGift) throws URISyntaxException {
        SampleGiftDto result = sampleGiftService.save(sampleGift);
        return ResponseEntity.created(new URI("/api/v1/sampleGifts/" + result.getId())).body(result);
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
