package com.bcnc.bcncprueba.application.dto;

import com.bcnc.bcncprueba.domain.entity.Price;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PriceResponseDTO {

    private Long productId;
    private Long brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double finalPrice;
    private String currency;

    public PriceResponseDTO(Price price) {
        this.productId = price.getProductId();
        this.brandId = price.getBrandId();
        this.priceList = price.getPriceList();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.finalPrice = price.getPrice();
        this.currency = price.getCurr();
    }
}
