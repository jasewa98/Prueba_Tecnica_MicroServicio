package com.bcnc.bcncprueba.initializer;

import com.bcnc.bcncprueba.domain.entity.Price;
import com.bcnc.bcncprueba.ports.repository.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final PriceRepository priceRepository;


    public DatabaseInitializer(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void run(String... args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Price price1 = new Price(1L,1L, LocalDateTime.parse("2020-06-14 00:00:00", formatter), LocalDateTime.parse("2020-12-31 23:59:59", formatter), 1, 35455L, 0, 35.50, "EUR");
        priceRepository.save(price1);

        Price price2 = new Price(2L,1L, LocalDateTime.parse("2020-06-14 15:00:00", formatter), LocalDateTime.parse("2020-06-14 18:30:00", formatter), 2, 35455L, 1, 25.45, "EUR");
        priceRepository.save(price2);

        Price price3 = new Price(3L,1L, LocalDateTime.parse("2020-06-15 00:00:00", formatter), LocalDateTime.parse("2020-06-15 11:00:00", formatter), 3, 35455L, 1, 30.50, "EUR");
        priceRepository.save(price3);

        Price price4 = new Price(4L,1L, LocalDateTime.parse("2020-06-15 16:00:00", formatter), LocalDateTime.parse("2020-12-31 23:59:59", formatter), 4, 35455L, 1, 38.95, "EUR");
        priceRepository.save(price4);

    }
}
