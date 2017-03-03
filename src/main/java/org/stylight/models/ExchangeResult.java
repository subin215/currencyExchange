package org.stylight.models;

/**
 * Created by Subin Sapkota on 3/3/17.
 */
public class ExchangeResult {

  private String fromCurrency;
  private String toCurrency;
  private double fromValue;
  private double exchangedValue;

  public String getFromCurrency() {
    return fromCurrency;
  }

  public void setFromCurrency(String fromCurrency) {
    this.fromCurrency = fromCurrency;
  }

  public String getToCurrency() {
    return toCurrency;
  }

  public void setToCurrency(String toCurrency) {
    this.toCurrency = toCurrency;
  }

  public double getFromValue() {
    return fromValue;
  }

  public void setFromValue(double fromValue) {
    this.fromValue = fromValue;
  }

  public double getExchangedValue() {
    return exchangedValue;
  }

  public void setExchangedValue(double exchangedValue) {
    this.exchangedValue = exchangedValue;
  }
}
