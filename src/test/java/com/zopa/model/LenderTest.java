package com.zopa.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class LenderTest {

  @Test
  public void testEquals() {
    Lender bob = new Lender("Bob", 0.075, 640L);
    Lender bob1 = new Lender("Bob", 0.075, 640L);
    Lender jane = new Lender("Jane", 0.069, 480L);

    assertEquals(bob, bob1);
    assertNotEquals(bob, jane);

  }

}
