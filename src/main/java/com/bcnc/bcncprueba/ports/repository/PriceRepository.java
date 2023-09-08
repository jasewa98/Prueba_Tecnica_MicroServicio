package com.bcnc.bcncprueba.ports.repository;

import com.bcnc.bcncprueba.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value = "SELECT * FROM PRICE WHERE BRAND_ID = :brandId AND PRODUCT_ID = :productId AND :targetDateTime BETWEEN START_DATE AND END_DATE ORDER BY PRIORITY DESC LIMIT 1", nativeQuery = true)
    Price findPriceByDateTimeBrandAndProduct(@Param("targetDateTime") LocalDateTime targetDateTime, @Param("brandId") Long brandId, @Param("productId") Long productId);

}
