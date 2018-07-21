package com.zopa.computation;

import static org.junit.Assert.assertEquals;

import com.zopa.model.Lender;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CreditComputationTest {

  private CreditComputation creditComputation;

  @Before
  public void init() {
    creditComputation = new CreditComputation();
  }

  @Test
  public void testMontlyRepayment() {
    Double mr1 = creditComputation.monthlyRepayment.apply(480L, 0.069);
    assertEquals(new Double(14.80), new Double(new BigDecimal(mr1).setScale(2, RoundingMode.HALF_UP).doubleValue()));

    Double mr2 = creditComputation.monthlyRepayment.apply(520L, 0.071);
    assertEquals(new Double(16.08), new Double(new BigDecimal(mr2).setScale(2, RoundingMode.HALF_UP).doubleValue()));

    Double mr3 = creditComputation.monthlyRepayment.apply(60L, 0.71);
    assertEquals(new Double(4.06), new Double(new BigDecimal(mr3).setScale(2, RoundingMode.HALF_UP).doubleValue()));
  }

  @Test
  public void testTotalRepayment() {
    Double mr1 = creditComputation.monthlyRepayment.apply(480L, 0.069);
    Double tr1 = creditComputation.totalRepayment.apply(mr1);
    assertEquals(new Double(532.77), new Double(new BigDecimal(tr1).setScale(2, RoundingMode.HALF_UP).doubleValue()));

    Double mr2 = creditComputation.monthlyRepayment.apply(520L, 0.071);
    Double tr2 = creditComputation.totalRepayment.apply(mr2);
    assertEquals(new Double(578.88), new Double(new BigDecimal(tr2).setScale(2, RoundingMode.HALF_UP).doubleValue()));
  }

  @Test
  public void testLendersByRate() {
    List<Lender> lenders = new ArrayList<>();
    lenders.add(new Lender("Bob", 0.075, 640L));
    lenders.add(new Lender("Jane", 0.069, 480L));
    lenders.add(new Lender("Fred", 0.071, 520L));
    lenders.add(new Lender("Mary", 0.104, 170L));
    lenders.add(new Lender("John", 0.081, 320L));
    lenders.add(new Lender("Dave", 0.074, 140L));
    lenders.add(new Lender("Angela", 0.071, 60L));

    List<Lender> lendersByRate = creditComputation.getLendersByRate.apply(lenders);
    assertEquals(lenders.get(1), lendersByRate.get(0));
    assertEquals(lenders.get(2), lendersByRate.get(1));
    assertEquals(lenders.get(6), lendersByRate.get(2));
    assertEquals(lenders.get(5), lendersByRate.get(3));
    assertEquals(lenders.get(0), lendersByRate.get(4));
    assertEquals(lenders.get(4), lendersByRate.get(5));
    assertEquals(lenders.get(3), lendersByRate.get(6));

  }

}
