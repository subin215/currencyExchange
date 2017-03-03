package stylight.exchangeAPI.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stylight.exchangeAPI.models.ExchangeResult;
import stylight.exchangeAPI.services.ExchangeService;

/**
 * REST Controller for handling exchange calls.
 *
 * Created by Subin Sapkota on 3/3/17.
 */
@RestController
public class ExchangeRestController {

  private final ExchangeService exchangeService;
  private final Logger logger = LoggerFactory.getLogger(ExchangeRestController.class);

  @Autowired
  public ExchangeRestController(ExchangeService exchangeService) {
    this.exchangeService = exchangeService;
  }

  /**
   * REST Endpoint controller for GET currency exchange results based on parameters.
   *
   * @param fromValue - double value of currency to be converted
   * @param fromCurr - String of currency to convert - Can be "USD", "EUR" or "JPY"
   * @param toCurr - String of currency to be converted to - Can be "USD", "EUR" or "JPY"
   * @return - ResponseEntity of error message or result.
   */
  @RequestMapping(value = "/exchange/{value}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<Object> getCurrencyExchangeResults(@PathVariable("value") double fromValue,
      @RequestParam("from") String fromCurr,
      @RequestParam("to") String toCurr) {

    // Validate parameters.
    if (!(fromCurr.equalsIgnoreCase("USD") || fromCurr.equalsIgnoreCase("JPY")
        || fromCurr.equalsIgnoreCase("EUR"))) {
      logger.error("INVALID! FROM Currency parameter didn't match USD, JPY, or EUR");
      return new ResponseEntity<>(
          "INVALID PARAMETER: FROM (from=) parameter mus be USD, EUR, or JPY only.",
          HttpStatus.BAD_REQUEST);
    }
    if (!(toCurr.equalsIgnoreCase("USD") || toCurr.equalsIgnoreCase("JPY")
        || toCurr.equalsIgnoreCase("EUR"))) {
      logger.error("INVALID! TO Currency parameter didn't match USD, JPY, or EUR");
      return new ResponseEntity<>(
          "INVALID PARAMETER: TO (to=) parameter mus be USD, EUR, or JPY only.",
          HttpStatus.BAD_REQUEST);
    }

    // Get Exchange Result.
    ExchangeResult exchangeResult = exchangeService
        .calculateCurrencyExchange(fromValue, fromCurr, toCurr);
    // If service found error during calculation.
    if (exchangeResult == null) {
      return new ResponseEntity<>("Error fetching exchange rate. Please try again!",
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
    logger.info("Successfully calculated exchange information. Response sent back.");
    return new ResponseEntity<Object>(exchangeResult, HttpStatus.OK);

  }

}
