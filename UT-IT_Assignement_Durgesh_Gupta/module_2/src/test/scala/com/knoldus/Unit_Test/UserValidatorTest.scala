package com.knoldus.Unit_Test

import com.knoldus.Implementation.UserImplementation
import com.knoldus.Validation.UserValidation
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class UserValidatorTest extends AsyncFlatSpec{
  val MockingCompanyValidation: UserValidation = mock[UserValidation]
  val Company = new UserImplementation(MockingCompanyValidation)
  // Company should not be in database
  "Company " should "not in database" in {
    when(MockingCompanyValidation.companyValid(company = "Microsoft")) thenReturn false
    val result = Company.companyExist(company = "Microsoft")
    assert(result == "no")
  }
  "Company " should "in database" in {
    when(MockingCompanyValidation.companyValid(company = "Knoldus")) thenReturn true
    val result = Company.companyExist(company = "Knoldus")
    assert(result == "yes")
  }
  // Validating Email Id
  val MockingEmailValidation: UserValidation = mock[UserValidation]
  val EmailId = new UserImplementation(MockingEmailValidation)
  "Email Id" should "be valid " in {
    when(MockingEmailValidation.emailValid(emailId = "durgesh@gmail.com")) thenReturn true
    val result = EmailId.emailId(email = "durgesh@gmail.com")
    assert(result == "valid")
  }
  "Email Id with wrong recipient" should "be not valid " in {
    when(MockingEmailValidation.emailValid(emailId = "@##durgesh@gmail.com")) thenReturn false
    val result = EmailId.emailId(email = "@##durgesh@gmail.com")
    assert(result == "invalid")
  }
  "Email Id without @ symbol" should "be not valid " in {
    when(MockingEmailValidation.emailValid(emailId = "durgeshgmail.com")) thenReturn false
    val result = EmailId.emailId(email = "durgeshgmail.com")
    assert(result == "invalid")
  }
  "Email Id with wrong domain name" should "be not valid " in {
    when(MockingEmailValidation.emailValid(emailId = "durgesh@##gmail.com")) thenReturn false
    val result = EmailId.emailId(email = "durgesh@##gmail.com")
    assert(result == "invalid")
  }
  "Email Id with wrong Top level domain" should "be not valid " in {
    when(MockingEmailValidation.emailValid(emailId = "durgesh@gmail.ccom")) thenReturn false
    val result = EmailId.emailId(email = "durgesh@gmail.ccom")
    assert(result == "invalid")
  }


}
