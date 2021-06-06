package com.target.targetcasestudy

import com.target.targetcasestudy.util.validateCreditCard
import org.junit.Assert
import org.junit.Test

/**
 * Feel free to make modifications to these unit tests! Remember, you have full technical control
 * over the project, so you can use any libraries and testing strategies that see fit.
 */
class CreditCardValidatorTest {

  @Test
  fun `is credit card number valid`() {
    Assert.assertTrue(
      "valid credit card number should yield true",
      validateCreditCard("4539976741512043")
    )
  }

  @Test
  fun `invalid Credit Card check - less than 14 `() {
    Assert.assertFalse(
      "valid credit card number should yield false",
      validateCreditCard("453997")
    )
  }

  @Test
  fun `invalid Credit Card check - greater than 18 `() {
    Assert.assertFalse(
      "valid credit card number should yield false",
      validateCreditCard("1234567890123456789")
    )
  }

}
