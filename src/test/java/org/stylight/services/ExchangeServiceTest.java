package org.stylight.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.stylight.models.ExchangeResult;
import org.stylight.services.implementation.ExchangeServiceImplementation;

/**
 * Created by Subin Sapkota on 3/3/17.
 */
@RunWith(SpringRunner.class)
public class ExchangeServiceTest {

  private ExchangeServiceImplementation exchangeService;

  @Before
  public void setUp(){
    exchangeService = new ExchangeServiceImplementation();
  }

  @Test
  public void testSuccessfulCalculateCurrencyExchange(){
    ExchangeResult result = exchangeService.calculateCurrencyExchange(1.0, "USD", "EUR");
    Assert.assertTrue("Exchange calculation successful, result {}", result != null);
  }
}
