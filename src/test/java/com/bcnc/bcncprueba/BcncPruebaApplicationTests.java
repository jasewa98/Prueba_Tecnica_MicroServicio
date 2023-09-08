package com.bcnc.bcncprueba;

import com.bcnc.bcncprueba.domain.entity.Price;
import com.bcnc.bcncprueba.domain.service.PriceServiceImpl;
import com.bcnc.bcncprueba.ports.repository.PriceRepository;
import com.bcnc.bcncprueba.ports.service.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class BcncPruebaApplicationTests {

    @Mock
    private PriceRepository priceRepository;

    @Autowired
    private PriceService priceService;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Test
    @DisplayName("Test 1")
    public void test1() {
        LocalDateTime dateTime = LocalDateTime.parse("2020-06-14 10:00:00", formatter);
        Long brandId = 1L;
        Long productId = 35455L;
        Price mockPrice = new Price();
        when(priceRepository.findPriceByDateTimeBrandAndProduct(dateTime, brandId, productId)).thenReturn(mockPrice);

        Price priceResponseDTO = priceService.getPrice(dateTime, brandId, productId);
        assertNotNull(priceResponseDTO);
    }

    @Test
    @DisplayName("Test 2")
    public void test2() {

        LocalDateTime dateTime = LocalDateTime.parse("2020-06-14 16:00:00", formatter);
        Long brandId = 1L;
        Long productId = 35455L;
        Price mockPrice = new Price();
        when(priceRepository.findPriceByDateTimeBrandAndProduct(dateTime, brandId, productId)).thenReturn(mockPrice);

        Price priceResponseDTO = priceService.getPrice(dateTime, brandId, productId);
        assertNotNull(priceResponseDTO);

    }

    @Test
    @DisplayName("Test 3")
    public void test3() {
        LocalDateTime dateTime = LocalDateTime.parse("2020-06-14 21:00:00", formatter);
        Long brandId = 1L;
        Long productId = 35455L;
        Price mockPrice = new Price();
        when(priceRepository.findPriceByDateTimeBrandAndProduct(dateTime, brandId, productId)).thenReturn(mockPrice);

        Price priceResponseDTO = priceService.getPrice(dateTime, brandId, productId);
        assertNotNull(priceResponseDTO);
    }

    @Test
    @DisplayName("Test 4")
    public void test4() {
        LocalDateTime dateTime = LocalDateTime.parse("2020-06-15 10:00:00", formatter);
        Long brandId = 1L;
        Long productId = 35455L;
        Price mockPrice = new Price();
        when(priceRepository.findPriceByDateTimeBrandAndProduct(dateTime, brandId, productId)).thenReturn(mockPrice);

        Price priceResponseDTO = priceService.getPrice(dateTime, brandId, productId);
        assertNotNull(priceResponseDTO);

    }

    @Test
    @DisplayName("Test 5")
    public void test5() {
        LocalDateTime dateTime = LocalDateTime.parse("2020-06-16 21:00:00", formatter);
        Long brandId = 1L;
        Long productId = 35455L;
        Price mockPrice = new Price();
        when(priceRepository.findPriceByDateTimeBrandAndProduct(dateTime, brandId, productId)).thenReturn(mockPrice);

        Price priceResponseDTO = priceService.getPrice(dateTime, brandId, productId);
        assertNotNull(priceResponseDTO);

    }

}
