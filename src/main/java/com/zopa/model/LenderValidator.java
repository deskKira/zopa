package com.zopa.model;

import java.util.Collection;

public class LenderValidator {

  Collection<Lender> lenders;

  public LenderValidator(Collection<Lender> lenders) {
    this.lenders = lenders;
  }

  public boolean checkSumEnough(final Long creditSum) {
      Long sum = lenders
          .stream()
          .mapToLong(Lender::getAvailable)
          .sum();
      if (creditSum.compareTo(sum) <= 0) {
        return true;
      }
      else {
        return false;
      }
  }

}
