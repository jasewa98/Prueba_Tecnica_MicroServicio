package com.bcnc.bcncprueba;

import com.bcnc.bcncprueba.domain.entity.Price;
import com.bcnc.bcncprueba.initializer.DatabaseInitializer;
import com.bcnc.bcncprueba.ports.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class BcncPruebaApplicationTests {

    @Autowired
    private PriceRepository priceRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Test
    @DisplayName("Test 1")
    public void test1() {
        Price priceResponseDTO = priceRepository.findPriceByDateTimeBrandAndProduct(LocalDateTime.parse("2020-06-14 10:00:00", formatter), 1L, 35455L);
        assertNotNull(priceResponseDTO);
    }

    @Test
    @DisplayName("Test 2")
    public void test2() {
        Price priceResponseDTO = priceRepository.findPriceByDateTimeBrandAndProduct(LocalDateTime.parse("2020-06-14 16:00:00", formatter), 1L, 35455L);
        assertNotNull(priceResponseDTO);

    }

    @Test
    @DisplayName("Test 3")
    public void test3() {
        Price priceResponseDTO = priceRepository.findPriceByDateTimeBrandAndProduct(LocalDateTime.parse("2020-06-14 21:00:00", formatter), 1L, 35455L);
        assertNotNull(priceResponseDTO);

    }

    @Test
    @DisplayName("Test 4")
    public void test4() {
        Price priceResponseDTO = priceRepository.findPriceByDateTimeBrandAndProduct(LocalDateTime.parse("2020-06-15 10:00:00", formatter), 1L, 35455L);
        assertNotNull(priceResponseDTO);

    }

    @Test
    @DisplayName("Test 5")
    public void test5() {
        Price priceResponseDTO = priceRepository.findPriceByDateTimeBrandAndProduct(LocalDateTime.parse("2020-06-16 21:00:00", formatter), 1L, 35455L);
        assertNotNull(priceResponseDTO);

    }

}
