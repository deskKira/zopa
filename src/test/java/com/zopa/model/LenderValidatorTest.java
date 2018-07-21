package com.zopa.model;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LenderValidatorTest {

  private LenderValidator lenderValidator;
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
    lenderValidator = new LenderValidator(lenders);
  }

  @Test
  public void testCheckSumEnough() {
    assertEquals(true, lenderValidator.checkSumEnough(1000L));
    assertEquals(false, lenderValidator.checkSumEnough(3000L));
  }

}
