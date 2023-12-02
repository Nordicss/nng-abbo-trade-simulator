package org.abbo.nng.client;

import jakarta.validation.Valid;
import org.nng.abbo.domain.sales.NngAbboSalesProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "orderManagementService", url = "${domains.services.hosts.oms}")
public interface NngAbboOrderManagementClient {
    @PostMapping(value = "/api/v1/add-sales")
    ResponseEntity<NngAbboSalesProduct> handleNngAbboOrder(@Valid @RequestBody NngAbboSalesProduct salesProduct);
}
