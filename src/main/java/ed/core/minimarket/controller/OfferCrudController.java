package ed.core.minimarket.controller;

import ed.core.minimarket.dto.ImageDto;
import ed.core.minimarket.dto.OfferDto;
import ed.core.minimarket.model.Image;
import ed.core.minimarket.model.Offer;
import ed.core.minimarket.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offer")
public class OfferCrudController {
    @Autowired
    private CrudService crudService;

    @PostMapping("/save")
    public ResponseEntity<OfferDto> saveOffer(@RequestBody OfferDto offerDto){
        return ResponseEntity.ok(crudService.saveOffer(offerDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOffer(@PathVariable String id){
        crudService.deleteOffer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<OfferDto> readOffer(@PathVariable String id){
        return ResponseEntity.ok(crudService.readOffer(id));
    }
    @GetMapping("/readAll")
    public ResponseEntity<List<OfferDto>> readAllOffers(){
        return ResponseEntity.ok(crudService.readAllOffers());
    }
    @PostMapping("/saveImage")
    public ResponseEntity<ImageDto> saveImage(@RequestBody ImageDto imageDto){
        return ResponseEntity.ok(crudService.saveImage(imageDto));
    }
}
