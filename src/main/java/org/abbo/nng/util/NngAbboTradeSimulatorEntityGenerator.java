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
    public static NngAbboSalesProduct createNngAbboOneTimeAnnualConsumption(String salesProductId,
                                                                            NngAbboProduct product,
                                                                            NngAbboCountry salesCountry,
                                                                            NngAbboClient client,
                                                                            NngPrice salesPrice,
                                                                            LocalDateTime salesCreatedTime,
                                                                            LocalDateTime startTime,
                                                                            LocalDateTime endTime) {
        return NngAbboOneTimeConsumption.builder()
                .salesProductId(salesProductId)
                .product(product)
                .salesCountry(salesCountry)
                .client(client)
                .salesPrice(salesPrice)
                .salesCreatedTime(salesCreatedTime)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }

    public static NngAbboSalesProduct createNngAbboTrialPackage(String salesProductId,
                                                                NngAbboProduct product,
                                                                NngAbboCountry salesCountry,
                                                                NngAbboClient client,
                                                                NngPrice salesPrice,
                                                                LocalDateTime salesCreatedTime,
                                                                LocalDateTime startTime,
                                                                LocalDateTime endTime) {
        return NngAbboTrialPackage.builder()
                .salesProductId(salesProductId)
                .product(product)
                .salesCountry(salesCountry)
                .client(client)
                .salesPrice(salesPrice)
                .salesCreatedTime(salesCreatedTime)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }

    public static NngAbboSalesProduct createNngAbboGeneralSubscription(String salesProductId,
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

    public static NngAbboTelephoneNumber createNngAbboTelephoneNumber(Integer countryCode, Long telephoneNumber) {
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
}
