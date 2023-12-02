package org.abbo.nng.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.abbo.nng.service.NngAbboTradeSimulatorService;
import org.nng.abbo.domain.product.NngAbboProduct;
import org.nng.abbo.domain.product.NngAbboProductCategory;
import org.nng.abbo.domain.sales.TradeSimulatorParameters;
import org.nng.abbo.domain.sales.TradeSimulatorResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

@Slf4j
@Service
public class NngAbboTradeSimulatorServiceImpl implements NngAbboTradeSimulatorService {

    private Integer generateRandomInteger(Integer roof) {
        return new Random().nextInt(roof);
    }


    @Override
    public TradeSimulatorResponse generateRandomSales(TradeSimulatorParameters parameters) {
        if (Objects.isNull(parameters)) {
            return TradeSimulatorResponse.builder()
                    .numberOfTrades(0)
                    .build();
        }

        Integer numberOfTrades = 0;
        LocalDate startDate = parameters.getFromDate().toLocalDate();
        LocalDate endDate = parameters.getToDate().toLocalDate();

        while (endDate.isAfter(startDate)) {
            Integer numberOfTradesPerDay = generateRandomInteger(
                    parameters.getMaximumTradesPerDay() - parameters.getMinimumTradesPerDay());

            for (int i = 0; i < (parameters.getMinimumTradesPerDay() + numberOfTradesPerDay); i++) {
                NngAbboProduct category = parameters.getProducts().get(generateRandomInteger(parameters.getProducts().size()));
            }
            numberOfTrades = numberOfTrades + 1;
            startDate = startDate.plusDays(1L);
        }

        return TradeSimulatorResponse.builder()
                .numberOfTrades(numberOfTrades)
                .build();
    }
}