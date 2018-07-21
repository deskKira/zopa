package com.zopa.computation;

import com.zopa.model.Lender;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CreditComputation {

  /**
   * Compute monthly repayment (36 month)
   */

  public BiFunction<Long, Double, Double> monthlyRepayment = (available, rate) ->
      available * ((rate / 12 * Math.pow(1 + rate / 12, 36)) / (Math.pow(1 + rate / 12, 36) -1));


  /**
   * Compute total repayment (36 month)
   */

  public Function<Double, Double> totalRepayment = (montlyPayment) -> montlyPayment * 36;

  /**
   * Sort lenders by rate field asc
   */

  public Function<List<Lender>, List<Lender>> getLendersByRate = (lenders) ->
      lenders.stream()
          .sorted(Comparator.comparing(Lender::getRate))
          .collect(Collectors.toList());

  /**
   * Calculate rate
   */
  public Function<List<Lender>, Double>  rateCalculate = (lenders) ->
        lenders.stream().mapToDouble(item -> item.getRate() * item.getAvailable()).sum()
        /
        lenders.stream().mapToLong(Lender::getAvailable).sum();

  /**
   * Get list of actual lenders sorted by minimal rate
   * @param lendersByRate - Sorted lenders list
   * @param creditSum - User credit sum
   * @return - List of lenders for compute with actual rate and available sum
   */

  public List<Lender> getLendersWithMinimalRate(final List<Lender> lendersByRate, final Long creditSum) {
    List<Lender> results = new ArrayList<>();
    Long balance = creditSum;
    for (Lender item : lendersByRate) {
      if (item.getAvailable().compareTo(balance) < 0) {
        results.add(item);
        balance -= item.getAvailable();
      }
      else if (item.getAvailable().compareTo(balance) > 0) {
        item.setAvailable(item.getAvailable() - (item.getAvailable() - balance));
        results.add(item);
        break;
      }
      else {
        results.add(item);
        break;
      }
    }
    return results;
  }

}
