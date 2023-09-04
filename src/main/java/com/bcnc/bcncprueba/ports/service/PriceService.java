package com.bcnc.bcncprueba.ports.service;

import com.bcnc.bcncprueba.domain.entity.Price;

import java.time.LocalDateTime;

public interface PriceService {
    Price getPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
