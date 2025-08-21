package ed.core.minimarket.service;

import ed.core.minimarket.dto.ImageDto;
import ed.core.minimarket.dto.OfferDto;

import java.util.List;

public interface CrudService {
    OfferDto saveOffer(OfferDto offerDto);
    void deleteOffer(String id);
    OfferDto readOffer(String id);
    List<OfferDto> readAllOffers();
    ImageDto saveImage(ImageDto imageDto);
}
