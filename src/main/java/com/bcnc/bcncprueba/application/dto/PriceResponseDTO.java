package com.bcnc.bcncprueba.application.dto;

import com.bcnc.bcncprueba.domain.entity.Price;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class PriceResponseDTO {

    private Long idPrice;
    private Long productId;
    private Long brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double finalPrice;
    private Integer priority;
    private String currency;

    public PriceResponseDTO(Price price) {
        this.idPrice = price.getIdPrice();
        this.productId = price.getProductId();
        this.brandId = price.getBrandId();
        this.priceList = price.getPriceList();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.priority = price.getPriority();
        this.finalPrice = price.getPrice();
        this.currency = price.getCurr();
    }
}
