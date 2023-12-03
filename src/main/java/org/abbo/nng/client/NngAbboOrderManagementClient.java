package org.abbo.nng.client;

import feign.Headers;
import jakarta.validation.Valid;
import org.nng.abbo.domain.sales.NngAbboSalesProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "orderManagementService", url = "${domains.services.hosts.oms}")
public interface NngAbboOrderManagementClient {
    @PostMapping(value = "/api/v1/add-sales")
    @Headers("Content-Type: application/json; charset=utf-8")
    ResponseEntity<NngAbboSalesProduct> handleNngAbboOrder(@Valid @RequestBody NngAbboSalesProduct salesProduct);
}
