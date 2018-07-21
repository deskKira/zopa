package com.zopa.service;

import static org.junit.Assert.assertEquals;
import com.zopa.model.Lender;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CreditServiceImplTest {

  private static final Long REQ_SUM = 1000L;

  private CreditService creditService;
  private List<Lender> lenders;

  @Before
  public void init() {
    lenders = new ArrayList<>();
    lenders.add(new Lender("Bob", 0.075, 640L));
    lenders.add(new Lender("Jane", 0.069, 480L));
    lenders.add(new Lender("Fred", 0.071, 520L));
    lenders.add(new Lender("Mary", 0.104, 170L));
    lenders.add(new Lender("John", 0.081, 320L));
    lenders.add(new Lender("Dave", 0.074, 140L));
    lenders.add(new Lender("Angela", 0.071, 60L));
    creditService = new CreditServiceImpl(lenders, REQ_SUM);
  }

  @Test
  public void testGetRequestedAmount() {
    assertEquals(REQ_SUM, creditService.getRequestedAmount());
  }

  @Test
  public void testGetRate() {
    assertEquals(new Double(0.070), new Double(new BigDecimal(creditService.getRate()).setScale(2, RoundingMode.HALF_UP).doubleValue()));
  }

  @Test
  public void testGetMonthlyRepayment() {
    assertEquals(new Double(30.88), new Double(new BigDecimal(creditService.getMonthlyRepayment()).setScale(2, RoundingMode.HALF_UP).doubleValue()));
  }

  @Test
  public void testGetTotalRepayment() {
    assertEquals(new Double(1111.64), new Double(new BigDecimal(creditService.getTotalRepayment()).setScale(2, RoundingMode.HALF_UP).doubleValue()));
  }

}
