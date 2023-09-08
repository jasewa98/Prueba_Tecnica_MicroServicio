package com.bcnc.bcncprueba.domain.service;

import com.bcnc.bcncprueba.domain.entity.Price;
import com.bcnc.bcncprueba.ports.repository.PriceRepository;
import com.bcnc.bcncprueba.ports.service.PriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    @Override
    @Transactional
    public Price getPrice(LocalDateTime targetDateTime, Long brandId, Long productId) {
        return priceRepository.findPriceByDateTimeBrandAndProduct(targetDateTime, brandId, productId);
    }
}
