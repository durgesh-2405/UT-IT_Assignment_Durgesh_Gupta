package com.knoldus.Unit_Test

import com.knoldus.Implementation.EmailImplementation
import com.knoldus.Validation.EmailValidation
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class EmailValidatorTest extends AsyncFlatSpec{
  val MockingEmailValidator : EmailValidation = mock[EmailValidation]
  val EmailId = new EmailImplementation(MockingEmailValidator)

  // Unit Test Cases for Validation of Email
  "Email Id" should "be valid " in {
    when(MockingEmailValidator.emailCheck(emailId = "durgesh@gmail.com")) thenReturn true
    val result = EmailId.callEmailId(email = "durgesh@gmail.com")
    assert(result == "yes")
  }
  "Email Id with wrong recipient" should "be not valid " in {
    when(MockingEmailValidator.emailCheck(emailId = "@##durgesh@gmail.com")) thenReturn false
    val result = EmailId.callEmailId(email = "@##durgesh@gmail.com")
    assert(result == "no")
  }
  "Email Id without @ symbol" should "be not valid " in {
    when(MockingEmailValidator.emailCheck(emailId = "durgeshgmail.com")) thenReturn false
    val result = EmailId.callEmailId(email = "durgeshgmail.com")
    assert(result == "no")
  }
  "Email Id with wrong domain name" should "be not valid " in {
    when(MockingEmailValidator.emailCheck(emailId = "durgesh@##gmail.com")) thenReturn false
    val result = EmailId.callEmailId(email = "durgesh@##gmail.com")
    assert(result == "no")
  }
  "Email Id with wrong Top level domain" should "be not valid " in {
    when(MockingEmailValidator.emailCheck(emailId = "durgesh@gmail.ccom")) thenReturn false
    val result = EmailId.callEmailId(email = "durgesh@gmail.ccom")
    assert(result == "no")
  }

}
