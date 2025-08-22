package ed.core.minimarket.mapper;

import ed.core.minimarket.dto.ImageDto;
import ed.core.minimarket.dto.OfferDto;
import ed.core.minimarket.model.Image;
import ed.core.minimarket.model.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperUtil {
    OfferDto toOfferDto(Offer offer);
    Offer toOfferEntity(OfferDto offerDto);
    @Mapping(target = "offerId", source = "offerId.id")
    ImageDto toImageDto(Image image);
    @Mapping(target = "offerId", ignore = true)
    Image toImageEntity(ImageDto imageDto);
    List<ImageDto> toImagesDto(List<Image> imageList);
    List<Image> toImages(List<ImageDto> imageList);
    List<OfferDto> toOffersDto(List<Offer> offerList);
    List<Offer> toOffers(List<OfferDto> offerList);
}
