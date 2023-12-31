package org.abbo.nng.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.abbo.nng.client.NngAbboCacheClient;
import org.abbo.nng.client.NngAbboCustomerClient;
import org.abbo.nng.client.NngAbboOrderManagementClient;
import org.abbo.nng.service.NngAbboTradeSimulatorService;
import org.abbo.nng.util.NngAbboTradeSimulatorEntityGenerator;
import org.nng.abbo.domain.client.NngAbboClient;
import org.nng.abbo.domain.documents.sales.NngAbboSubscriptionPriceDocument;
import org.nng.abbo.domain.geography.*;
import org.nng.abbo.domain.product.NngAbboProduct;
import org.nng.abbo.domain.sales.*;
import org.nng.abbo.domain.shipment.NngAbboShipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
public class NngAbboTradeSimulatorServiceImpl implements NngAbboTradeSimulatorService {
    private final NngAbboCacheClient cacheClient;
    private final NngAbboCustomerClient customerClient;
    private final NngAbboOrderManagementClient orderManagementClient;

    @Autowired
    public NngAbboTradeSimulatorServiceImpl(NngAbboCacheClient cacheClient,
                                            NngAbboCustomerClient customerClient,
                                            NngAbboOrderManagementClient orderManagementClient) {
        this.cacheClient = cacheClient;
        this.customerClient = customerClient;
        this.orderManagementClient = orderManagementClient;
    }

    private Integer generateRandomInteger(Integer roof) {
        return new Random().nextInt(roof);
    }

    private Long generateRandomLong(Long roof) {
        return new Random().nextLong(roof);
    }


    @Override
    public TradeSimulatorResponse generateRandomSales(TradeSimulatorParameters parameters) {
        if (Objects.isNull(parameters)) {
            return TradeSimulatorResponse.builder()
                    .numberOfTrades(0)
                    .build();
        }

        Integer numberOfTrades = 0;
        LocalDate startDate = parameters.getFromDate();
        LocalDate endDate = parameters.getToDate();

        log.info("Starting generating random trades betweeb {} - AND {}", startDate, endDate);
        while (endDate.isAfter(startDate)) {
            Integer numberOfTradesPerDay = generateRandomInteger(
                    parameters.getMaximumTradesPerDay() - parameters.getMinimumTradesPerDay());

            for (int i = 0; i < (parameters.getMinimumTradesPerDay() + numberOfTradesPerDay); i++) {
                NngAbboProduct product = parameters.getProducts().get(generateRandomInteger(parameters.getProducts().size()));
                NngAbboSalesType salesType = parameters.getSalesTypes().get(generateRandomInteger(parameters.getSalesTypes().size()));
                NngAbboCountry country = parameters.getCountries().get(generateRandomInteger(parameters.getCountries().size()));

                NngAbboClient newClient = NngAbboTradeSimulatorEntityGenerator.generateClient();
                customerClient.upsertClient(newClient);

                NngAbboSubscriptionPriceDocument salesPrice = cacheClient.purchaseProduct(
                        NngAbboSubscriptionPriceKey.builder()
                                .productId(product.getProductId())
                                .countryISO2(country.getIsoCountryAlphaTwo())
                                .salesType(salesType)
                                .build()
                ).getBody();

                NngAbboSalesProduct oneSale = NngAbboTradeSimulatorEntityGenerator.generateSalesProduct(
                        product,
                        newClient,
                        salesType,
                        salesPrice.getPrice(),
                        startDate,
                        country
                );

                List<NngAbboShipment> shipmentList = NngAbboTradeSimulatorEntityGenerator.createShipmentScheduleForSubscription(oneSale);
                oneSale.setShipments(shipmentList);
                oneSale.setNextDueShipment(findNextShipment(shipmentList));
                orderManagementClient.handleNngAbboOrder(oneSale);
                numberOfTrades = numberOfTrades + 1;

                Long sleepInMS = generateRandomLong((parameters.getMaximumThrottleInMS() - parameters.getMinimumThrottleInMS()));
                try {
                    Thread.sleep((parameters.getMinimumThrottleInMS() + sleepInMS));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            startDate = startDate.plusDays(1L);
        }

        log.info("Finished creating {} of trades!", numberOfTrades);
        return TradeSimulatorResponse.builder()
                .numberOfTrades(numberOfTrades)
                .build();
    }

    private LocalDate findNextShipment(List<NngAbboShipment> shipments) {
        return CollectionUtils.isEmpty(shipments) ? null :
                Collections.min(shipments.stream()
                        .map(NngAbboShipment::getDueDate)
                        .toList()
                        .stream()
                        .toList());
    }
}
