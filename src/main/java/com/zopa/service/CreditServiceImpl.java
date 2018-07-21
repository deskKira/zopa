package com.zopa.service;

import com.zopa.computation.CreditComputation;
import com.zopa.model.Lender;
import java.util.List;

public class CreditServiceImpl implements CreditService {

  private CreditComputation computation;
  private List<Lender> lenders;
  private Long amount;

  public CreditServiceImpl(List<Lender> lenders, Long amount) {
    this.computation = new CreditComputation();
    this.amount = amount;
    this.lenders = computation.getLendersWithMinimalRate(computation.getLendersByRate.apply(lenders), amount);
  }


  @Override
  public Long getRequestedAmount() {
    return amount;
  }

  @Override
  public Double getRate() {
    return computation.rateCalculate.apply(lenders);
  }

  @Override
  public Double getMonthlyRepayment() {
    return lenders.stream()
          .mapToDouble(item -> computation.monthlyRepayment.apply(item.getAvailable(), item.getRate()))
          .sum();
  }

  @Override
  public Double getTotalRepayment() {
    return lenders.stream()
          .mapToDouble(item -> computation.monthlyRepayment.apply(item.getAvailable(), item.getRate()) * 36)
          .sum();
  }
}
