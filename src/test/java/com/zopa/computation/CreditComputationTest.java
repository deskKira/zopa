package com.zopa.computation;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

}
