package org.abbo.nng.client;

import feign.Headers;
import org.nng.abbo.domain.documents.sales.NngAbboSubscriptionPriceDocument;
import org.nng.abbo.domain.sales.NngAbboSubscriptionPriceKey;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cacheService", url = "${domains.services.hosts.caching}")
public interface NngAbboCacheClient {
    @PostMapping(value = "/api/v1/get-price-for-subscription")
    @Headers("Content-Type: application/json; charset=utf-8")
    ResponseEntity<NngAbboSubscriptionPriceDocument> purchaseProduct(NngAbboSubscriptionPriceKey request);

    @GetMapping(value = "/api/v1/get-cost-per-order/{productId}")
    @Headers("Content-Type: application/json; charset=utf-8")
    ResponseEntity<Double> getMarketingCostPerOrder(@PathVariable("productId") String productId);
}
