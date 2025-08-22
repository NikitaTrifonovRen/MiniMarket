package ed.core.minimarket.service;

import ed.core.minimarket.dto.ImageDto;
import ed.core.minimarket.dto.OfferDto;
import ed.core.minimarket.mapper.MapperUtil;
import ed.core.minimarket.model.Image;
import ed.core.minimarket.model.Offer;
import ed.core.minimarket.repository.ImageRepository;
import ed.core.minimarket.repository.OfferRepository;
import jakarta.persistence.EntityManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CrudServiceImpl implements CrudService {

    private final ImageRepository imageRepository;

    private final OfferRepository offerRepository;

    private final MapperUtil mapperUtil;
    private final EntityManager entityManager;



    public CrudServiceImpl(ImageRepository imageRepository, OfferRepository offerRepository, MapperUtil mapperUtil, EntityManager entityManager) {
        this.imageRepository = imageRepository;
        this.offerRepository = offerRepository;
        this.mapperUtil = mapperUtil;
        this.entityManager = entityManager;
    }
    @Override
    @CachePut(value = "offer", key = "#result.id")
    @Transactional(propagation = Propagation.REQUIRED)
    public OfferDto saveOffer(OfferDto offerDto){
        Offer result = offerRepository.save(mapperUtil.toOfferEntity(offerDto));
        offerDto.setId(result.getId());
        return offerDto;
    }
    @Override
    @CacheEvict(value = "offer", key = "#id")
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteOffer(String id){
        offerRepository.deleteById(id);
    }
    @Override
    @Cacheable(value = "offer", key = "#id")
    @Transactional(propagation = Propagation.REQUIRED)
    public OfferDto readOffer(String id){
        Offer offer = offerRepository.findById(id).orElse(null);
        return mapperUtil.toOfferDto(offer);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<OfferDto> readAllOffers(){
        List<Offer> offerList = offerRepository.findAll();
        return mapperUtil.toOffersDto(offerList);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ImageDto saveImage(ImageDto imageDto){
        Image newImage = mapperUtil.toImageEntity(imageDto);
        Image image = imageRepository.save(newImage);
        image.setOfferId(offerRepository.findById(imageDto.getOfferId()).orElse(null));
        imageRepository.save(image);
        imageDto.setId(image.getId());
        return imageDto;
    }


}
