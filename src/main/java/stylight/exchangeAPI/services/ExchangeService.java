package stylight.exchangeAPI.services;

import stylight.exchangeAPI.models.ExchangeResult;

/**
 * Exchange service interface for methods to implement.
 *
 * Created by Subin Sapkota on 3/3/17.
 */
public interface ExchangeService {

  /**
   * Calculate exchange value from provided value of currency.
   *
   * @param fromValue - double value of currency to be converted
   * @param fromCurr - String of currency to convert - Can be "USD", "EUR" or "JPY"
   * @param toCurr - String of currency to be converted to - Can be "USD", "EUR" or "JPY"
   * @return - ExchangeResult object with results.
   */
  ExchangeResult calculateCurrencyExchange(double fromValue, String fromCurr, String toCurr);
}
