package com.bcnc.bcncprueba.domain.service;

import com.bcnc.bcncprueba.domain.entity.Price;
import com.bcnc.bcncprueba.ports.repository.PriceRepository;
import com.bcnc.bcncprueba.ports.service.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    @Override
    public Price getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        // Lógica de negocio
        return priceRepository.findPriceByDateTimeBrandAndProduct(applicationDate, brandId, productId);
    }
}
