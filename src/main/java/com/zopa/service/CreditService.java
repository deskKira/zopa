package com.zopa.service;

public interface CreditService {

  public Long getRequestedAmount();

  public Double getRate();

  public Double getMonthlyRepayment();

  public Double getTotalRepayment();

}
