package org.abbo.nng.service;

import org.nng.abbo.domain.sales.TradeSimulatorParameters;
import org.nng.abbo.domain.sales.TradeSimulatorResponse;

public interface NngAbboTradeSimulatorService {
    TradeSimulatorResponse generateRandomSales(TradeSimulatorParameters parameters);
}
