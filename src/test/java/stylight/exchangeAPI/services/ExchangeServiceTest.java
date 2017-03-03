package stylight.exchangeAPI.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import stylight.exchangeAPI.models.ExchangeResult;
import stylight.exchangeAPI.services.implementation.ExchangeServiceImplementation;

/**
 * ExchangeServiceTest - Unit test for ExchangeService class.
 *
 * Created by Subin Sapkota on 3/3/17.
 */
@RunWith(SpringRunner.class)
public class ExchangeServiceTest {

  private ExchangeServiceImplementation exchangeService;

  @Before
  public void setUp() {
    exchangeService = new ExchangeServiceImplementation();
  }

  @Test
  public void testSuccessfulCalculateCurrencyExchange() {
    ExchangeResult result = exchangeService.calculateCurrencyExchange(1.0, "USD", "EUR");
    Assert.assertTrue("Exchange calculation successful, result {}", result != null);
  }

  @Test
  public void testEmptyFromCurrCalculateCurrencyExchange() {
    ExchangeResult result = exchangeService.calculateCurrencyExchange(1.0, null, "EUR");
    Assert.assertEquals(result, null);
  }

  @Test
  public void testEmptyToCurrCalculateCurrencyExchange() {
    ExchangeResult result = exchangeService.calculateCurrencyExchange(1.0, "EUR", null);
    Assert.assertEquals(result, null);
  }

  @Test
  public void testMaxDoubleCalculateCurrencyExchange() {
    ExchangeResult result = exchangeService
        .calculateCurrencyExchange(Double.MAX_VALUE, "EUR", "USD");
    Assert.assertTrue("Exchange calculation with MAX Double value successful", result != null);
  }

  @Test
  public void testMinDoubleCalculateCurrencyExchange() {
    ExchangeResult result = exchangeService
        .calculateCurrencyExchange(-Double.MAX_VALUE, "EUR", "USD");
    Assert.assertTrue("Exchange calculation with MIN Double value successful", result != null);
  }

  @Test
  public void testZeroCalculateCurrencyExchange() {
    ExchangeResult result = exchangeService
        .calculateCurrencyExchange(Double.MIN_VALUE, "EUR", "USD");
    Assert.assertEquals(result.getExchangedValue(), Double.MIN_VALUE, 0.0);
  }
}
