package org.abbo.nng.util;

import org.nng.abbo.domain.client.NngAbboClient;
import org.nng.abbo.domain.client.NngAbboNewClient;
import org.nng.abbo.domain.credit.CreditApprovedCustomer;
import org.nng.abbo.domain.geography.*;
import org.nng.abbo.domain.product.*;
import org.nng.abbo.domain.sales.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class NngAbboTradeSimulatorEntityGenerator {
    public static NngAbboSalesProduct createNngAbboOneTimeOneYearConsumption(String salesProductId,
                                                                             NngAbboSubscriptionPriceKey subscriptionKey,
                                                                             NngAbboProduct product,
                                                                             NngAbboCountry salesCountry,
                                                                             NngAbboClient client,
                                                                             NngPrice salesPrice,
                                                                             LocalDateTime salesCreatedTime,
                                                                             LocalDateTime startTime,
                                                                             LocalDateTime endTime) {
        return NngAbboOneTimeConsumption.builder()
                .salesProductId(salesProductId)
                .subscriptionKey(subscriptionKey.getKey())
                .product(product)
                .salesCountry(salesCountry)
                .client(client)
                .salesPrice(salesPrice)
                .salesType(NngAbboSalesType.ONE_TIME_CONSUMPTION_ONE_YEAR)
                .salesCreatedTime(salesCreatedTime)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }

    public static NngAbboSalesProduct createNngAbboOneTimeThreeYearConsumption(String salesProductId,
                                                                               NngAbboSubscriptionPriceKey subscriptionKey,
                                                                               NngAbboProduct product,
                                                                               NngAbboCountry salesCountry,
                                                                               NngAbboClient client,
                                                                               NngPrice salesPrice,
                                                                               LocalDateTime salesCreatedTime,
                                                                               LocalDateTime startTime,
                                                                               LocalDateTime endTime) {
        return NngAbboOneTimeConsumption.builder()
                .salesProductId(salesProductId)
                .subscriptionKey(subscriptionKey.getKey())
                .product(product)
                .salesCountry(salesCountry)
                .client(client)
                .salesPrice(salesPrice)
                .salesType(NngAbboSalesType.ONE_TIME_CONSUMPTION_THREE_YEAR)
                .salesCreatedTime(salesCreatedTime)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }

    public static NngAbboSalesProduct createNngAbboTrialPackage(String salesProductId,
                                                                NngAbboSubscriptionPriceKey subscriptionKey,
                                                                NngAbboProduct product,
                                                                NngAbboCountry salesCountry,
                                                                NngAbboClient client,
                                                                NngPrice salesPrice,
                                                                LocalDateTime salesCreatedTime,
                                                                LocalDateTime startTime,
                                                                LocalDateTime endTime) {
        return NngAbboTrialPackage.builder()
                .salesProductId(salesProductId)
                .subscriptionKey(subscriptionKey.getKey())
                .product(product)
                .salesCountry(salesCountry)
                .client(client)
                .salesPrice(salesPrice)
                .salesCreatedTime(salesCreatedTime)
                .startTime(startTime)
                .endTime(endTime)
                .salesType(NngAbboSalesType.TRIAL_PACKAGE)
                .build();
    }

    public static NngAbboSalesProduct createNngAbboGeneralSubscription(String salesProductId,
                                                                       NngAbboSubscriptionPriceKey subscriptionKey,
                                                                       NngAbboProduct product,
                                                                       NngAbboCountry salesCountry,
                                                                       NngAbboClient client,
                                                                       NngPrice salesPrice,
                                                                       LocalDateTime salesCreatedTime,
                                                                       LocalDateTime startTime,
                                                                       LocalDateTime endTime,
                                                                       NngAbboSalesPeriod salesPeriod) {
        return NngAbboGeneralSubscription.builder()
                .salesProductId(salesProductId)
                .subscriptionKey(subscriptionKey.getKey())
                .product(product)
                .salesCountry(salesCountry)
                .client(client)
                .salesPrice(salesPrice)
                .salesCreatedTime(salesCreatedTime)
                .startTime(startTime)
                .endTime(endTime)
                .salesPeriod(salesPeriod)
                .build();
    }

    public static NngAbboProduct createCosmeticProduct(String productTypeId,
                                                       String productName,
                                                       String productDescription,
                                                       NngPrice price) {
        return NngAbboCosmeticProduct.builder()
                .productId(UUID.randomUUID().toString())
                .productTypeId(UUID.fromString(productTypeId).toString())
                .productName(productName)
                .productDescription(productDescription)
                .costOfGoods(price)
                .build();
    }

    public static NngAbboProduct createCreamProduct(String productTypeId,
                                                    String productName,
                                                    String productDescription,
                                                    NngPrice price) {
        return NngAbboCreamProduct.builder()
                .productId(UUID.randomUUID().toString())
                .productTypeId(UUID.fromString(productTypeId).toString())
                .productName(productName)
                .productDescription(productDescription)
                .costOfGoods(price)
                .build();
    }

    public static NngAbboProduct createFlyerProduct(String productTypeId,
                                                    String productName,
                                                    String productDescription,
                                                    NngPrice price) {
        return NngAbboFlyersProduct.builder()
                .productId(UUID.randomUUID().toString())
                .productTypeId(UUID.fromString(productTypeId).toString())
                .productName(productName)
                .productDescription(productDescription)
                .costOfGoods(price)
                .build();
    }

    public static NngAbboProduct createHealthProduct(String productTypeId,
                                                     String productName,
                                                     String productDescription,
                                                     NngPrice price) {
        return NngAbboHealthProduct.builder()
                .productId(UUID.randomUUID().toString())
                .productTypeId(UUID.fromString(productTypeId).toString())
                .productName(productName)
                .productDescription(productDescription)
                .costOfGoods(price)
                .build();
    }

    public static NngAbboProduct createPackagingProduct(String productTypeId,
                                                        String productName,
                                                        String productDescription,
                                                        NngPrice price,
                                                        Integer xDimension,
                                                        Integer yDimension,
                                                        Integer zDimension) {
        return NngAbboPackagingProduct.builder()
                .productId(UUID.randomUUID().toString())
                .productTypeId(UUID.fromString(productTypeId).toString())
                .productName(productName)
                .productDescription(productDescription)
                .costOfGoods(price)
                .xDimension(xDimension)
                .yDimension(yDimension)
                .zDimension(zDimension)
                .build();
    }

    public static NngPrice createPrice(String currency, Double price) {
        return NngPrice.builder()
                .currency(currency)
                .price(price)
                .build();
    }

    public static NngAbboTelephoneNumber createNngAbboTelephoneNumber(String countryCode, String telephoneNumber) {
        return NngAbboTelephoneNumber.builder()
                .countryCode(countryCode)
                .number(telephoneNumber)
                .build();
    }

    public static NngAbboNationalIdNumber createNngAbboNationalIdNumber(NngAbboCountry country, String identityNumber) {
        return NngAbboNationalIdNumber.builder()
                .country(country)
                .identityNumber(identityNumber)
                .build();
    }

    public static NngAbboName createNngAbboName(String firstName, String middleName, String lastName, String preferredName) {
        return NngAbboName.builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .preferredName(preferredName)
                .build();
    }

    public static NngAbboStreetAddress createNngAbboStreetAddress(String streetName, String apartmentNumber) {
        return NngAbboStreetAddress.builder()
                .streetName(streetName)
                .apartmentNumber(apartmentNumber)
                .build();
    }

    public static NngAbboCountry createNngAbboCountry(String countryName, String isoCountryAlphaTwo, String isoCurrencyAlphaThree) {
        return NngAbboCountry.builder()
                .countryName(countryName)
                .isoCountryAlphaTwo(isoCountryAlphaTwo)
                .isoCurrencyAlphaThree(isoCurrencyAlphaThree)
                .build();
    }

    public static NngAbboAddress createNngAbboAddress(NngAbboStreetAddress streetAddress,
                                                      String postCode,
                                                      String municipality,
                                                      String city,
                                                      String state,
                                                      NngAbboCountry country) {
        return NngAbboAddress.builder()
                .streetAddress(streetAddress)
                .postCode(postCode)
                .municipality(municipality)
                .city(city)
                .state(state)
                .country(country)
                .build();
    }

    public static NngAbboClient createNngAbboNewClient(String clientID,
                                                       NngAbboNationalIdNumber nngAbboNationalIdNumber,
                                                       NngAbboName clientName,
                                                       NngAbboTelephoneNumber clientTelephoneNumber,
                                                       NngAbboAddress clientAddress,
                                                       LocalDateTime clientCreatedTime,
                                                       CreditApprovedCustomer creditApprovedCustomer) {
        return NngAbboNewClient.builder()
                .clientID(clientID)
                .nationalIdNumber(nngAbboNationalIdNumber)
                .clientName(clientName)
                .clientTelephoneNumber(clientTelephoneNumber)
                .clientAddress(clientAddress)
                .clientCreatedTime(clientCreatedTime)
                .creditApprovedCustomer(creditApprovedCustomer)
                .build();
    }

    public static NngAbboClient createNngAbboExistingClient(String clientID,
                                                            NngAbboNationalIdNumber nngAbboNationalIdNumber,
                                                            NngAbboName clientName,
                                                            NngAbboTelephoneNumber clientTelephoneNumber,
                                                            NngAbboAddress clientAddress,
                                                            LocalDateTime clientCreatedTime,
                                                            CreditApprovedCustomer creditApprovedCustomer) {
        return NngAbboNewClient.builder()
                .clientID(clientID)
                .nationalIdNumber(nngAbboNationalIdNumber)
                .clientName(clientName)
                .clientTelephoneNumber(clientTelephoneNumber)
                .clientAddress(clientAddress)
                .clientCreatedTime(clientCreatedTime)
                .creditApprovedCustomer(creditApprovedCustomer)
                .build();
    }

    public static NngAbboClient generateClient() {
        NngAbboTelephoneNumber number = NngAbboTradeSimulatorEntityGenerator.createNngAbboTelephoneNumber("44", "79502934254");
        NngAbboName name = NngAbboTradeSimulatorEntityGenerator.createNngAbboName("John", "Q", "Citizen", "John");
        NngAbboStreetAddress streetAddress = NngAbboTradeSimulatorEntityGenerator.createNngAbboStreetAddress("Main Street", "102A");
        NngAbboCountry country = NngAbboTradeSimulatorEntityGenerator.createNngAbboCountry("United Kingdom", "GB", "GBR");
        NngAbboNationalIdNumber nationalIdNumber = NngAbboTradeSimulatorEntityGenerator.createNngAbboNationalIdNumber(country, "M01010276854");
        NngAbboAddress address = NngAbboTradeSimulatorEntityGenerator.createNngAbboAddress(streetAddress, "W53UP", "Greater London", "London", null, country);

        return NngAbboTradeSimulatorEntityGenerator.createNngAbboNewClient(
                UUID.randomUUID().toString(),
                nationalIdNumber,
                name,
                number,
                address,
                LocalDateTime.now(),
                CreditApprovedCustomer.builder().isApproved(true).build());
    }

    public static NngAbboSalesProduct generateSalesProduct(NngAbboProduct product,
                                                           NngAbboClient client,
                                                           NngAbboSalesType salesType,
                                                           NngPrice salesPrice,
                                                           LocalDateTime createdTime,
                                                           NngAbboCountry country
    ) {

        NngAbboSalesProduct salesProduct = null;
        switch (salesType) {
            case TRIAL_PACKAGE -> salesProduct = NngAbboTradeSimulatorEntityGenerator.createNngAbboTrialPackage(
                    UUID.randomUUID().toString(),
                    NngAbboSubscriptionPriceKey.builder()
                            .productId(product.getProductId())
                            .countryISO2(country.getIsoCountryAlphaTwo())
                            .salesType(salesType)
                            .build(),
                    product,
                    country,
                    client,
                    salesPrice,
                    createdTime,
                    createdTime,
                    createdTime
            );
            case GENERAL_SUBSCRIPTION ->
                    salesProduct = NngAbboTradeSimulatorEntityGenerator.createNngAbboGeneralSubscription(
                            UUID.randomUUID().toString(),
                            NngAbboSubscriptionPriceKey.builder()
                                    .productId(product.getProductId())
                                    .countryISO2(country.getIsoCountryAlphaTwo())
                                    .salesType(salesType)
                                    .build(),
                            product,
                            country,
                            client,
                            salesPrice,
                            LocalDateTime.now(),
                            LocalDateTime.now(),
                            LocalDateTime.now(),
                            NngAbboSalesPeriod.QUARTERLY
                    );
            case ONE_TIME_CONSUMPTION_ONE_YEAR ->
                    salesProduct = NngAbboTradeSimulatorEntityGenerator.createNngAbboOneTimeOneYearConsumption(
                            UUID.randomUUID().toString(),
                            NngAbboSubscriptionPriceKey.builder()
                                    .productId(product.getProductId())
                                    .countryISO2(country.getIsoCountryAlphaTwo())
                                    .salesType(salesType)
                                    .build(),
                            product,
                            country,
                            client,
                            salesPrice,
                            createdTime,
                            createdTime,
                            createdTime
                    );
            case ONE_TIME_CONSUMPTION_THREE_YEAR ->
                    salesProduct = NngAbboTradeSimulatorEntityGenerator.createNngAbboOneTimeThreeYearConsumption(
                            UUID.randomUUID().toString(),
                            NngAbboSubscriptionPriceKey.builder()
                                    .productId(product.getProductId())
                                    .countryISO2(country.getIsoCountryAlphaTwo())
                                    .salesType(salesType)
                                    .build(),
                            product,
                            country,
                            client,
                            salesPrice,
                            createdTime,
                            createdTime,
                            createdTime
                    );
        }

        return salesProduct;
    }
}
