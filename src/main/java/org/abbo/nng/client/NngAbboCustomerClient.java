package org.abbo.nng.client;

import jakarta.validation.Valid;
import org.nng.abbo.domain.client.NngAbboClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "clientService", url = "${domains.services.hosts.client}")
public interface NngAbboCustomerClient {
    @PostMapping(value = "/api/v1/upsert-client", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<NngAbboClient> upsertClient(@Valid @RequestBody NngAbboClient request);
}
