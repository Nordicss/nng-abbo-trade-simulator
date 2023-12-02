package org.abbo.nng.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.abbo.nng.service.NngAbboTradeSimulatorService;
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

        while (startDate.isBefore(endDate)) {
            Integer numberOfTradesPerDay = generateRandomInteger(
                    parameters.getMaximumTradesPerDay() - parameters.getMinimumTradesPerDay());

            for (int i = parameters.getMinimumTradesPerDay(); i < (parameters.getMinimumTradesPerDay() + numberOfTradesPerDay); i++) {
                NngAbboProductCategory category = parameters.getCategoryList().get(generateRandomInteger(parameters.getCategoryList().size()));
                log.info("This is the category: {}", category);
            }
            numberOfTrades = numberOfTrades + 1;
            startDate = startDate.plusDays(1L);
        }

        return TradeSimulatorResponse.builder()
                .numberOfTrades(numberOfTrades)
                .build();
    }
}
