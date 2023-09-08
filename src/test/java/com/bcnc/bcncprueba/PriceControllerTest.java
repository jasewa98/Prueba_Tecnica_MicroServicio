package com.bcnc.bcncprueba;

import com.bcnc.bcncprueba.application.controller.PriceController;
import com.bcnc.bcncprueba.domain.entity.Price;
import com.bcnc.bcncprueba.ports.service.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PriceController.class)
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void getPrice_givenValidParameters_returnsPrice() throws Exception {
        LocalDateTime sampleDateTime = LocalDateTime.parse("2020-06-14T15:00:00");
        Long sampleProductId = 35455L;
        Long sampleBrandId = 1L;

        Price mockPrice = new Price();

        when(priceService.getPrice(sampleDateTime, sampleProductId, sampleBrandId)).thenReturn(mockPrice);

        ResultActions result = mockMvc.perform(get("/api/prices")
                .param("applicationDate", sampleDateTime.toString())
                .param("productId", sampleProductId.toString())
                .param("brandId", sampleBrandId.toString())
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getPrice_whenPriceDoesNotExist_returnsNotFound() throws Exception {
        LocalDateTime sampleDateTime = LocalDateTime.parse("2020-06-14T15:00:00");
        Long sampleProductId = 35455L;
        Long sampleBrandId = 1L;

        when(priceService.getPrice(sampleDateTime, sampleProductId, sampleBrandId)).thenReturn(null);

        ResultActions result = mockMvc.perform(get("/api/prices")
                .param("applicationDate", sampleDateTime.toString())
                .param("productId", sampleProductId.toString())
                .param("brandId", sampleBrandId.toString())
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }
}
