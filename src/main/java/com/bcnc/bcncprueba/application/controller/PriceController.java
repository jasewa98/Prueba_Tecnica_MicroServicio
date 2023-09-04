package com.bcnc.bcncprueba.application.controller;

import com.bcnc.bcncprueba.application.dto.PriceResponseDTO;
import com.bcnc.bcncprueba.domain.entity.Price;
import com.bcnc.bcncprueba.ports.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<PriceResponseDTO> getPrice(@RequestParam LocalDateTime applicationDate,
                                                     @RequestParam Long productId,
                                                     @RequestParam Long brandId) {
        Price price = priceService.getPrice(applicationDate, productId, brandId);
        if(price == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        PriceResponseDTO response = new PriceResponseDTO(price);
        return ResponseEntity.ok(response);
    }
}
