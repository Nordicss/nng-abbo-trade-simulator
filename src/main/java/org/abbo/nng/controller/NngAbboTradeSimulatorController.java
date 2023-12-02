package org.abbo.nng.controller;

import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.abbo.nng.service.NngAbboTradeSimulatorService;
import org.nng.abbo.domain.sales.TradeSimulatorParameters;
import org.nng.abbo.domain.sales.TradeSimulatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class NngAbboTradeSimulatorController {
    private final NngAbboTradeSimulatorService service;

    @Autowired
    public NngAbboTradeSimulatorController(NngAbboTradeSimulatorService service) {
        this.service = service;
    }

    @ApiOperation(value = "Simulates Random sales")
    @PostMapping(value = "/simulate-sales", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TradeSimulatorResponse> handleNngAbboOrder(@Valid @RequestBody TradeSimulatorParameters parameters) {
        TradeSimulatorResponse numberOfSalesGenerated = service.generateRandomSales(parameters);

        return ResponseEntity.ok(numberOfSalesGenerated);
    }
}
