package org.stylight.services;

import org.stylight.models.ExchangeResult;

/**
 * Created by Subin Sapkota on 3/3/17.
 */
public interface ExchangeService {
  ExchangeResult calculateCurrencyExchange(double fromValue, String fromCurr, String toCurr);
}
