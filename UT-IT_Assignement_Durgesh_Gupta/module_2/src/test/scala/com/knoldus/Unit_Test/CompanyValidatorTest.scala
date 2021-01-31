package com.knoldus.Unit_Test

import com.knoldus.Implementation.CompanyImplementation
import com.knoldus.Validation.CompanyValidation
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class CompanyValidatorTest extends AsyncFlatSpec{

  val MockingCompanyValidator: CompanyValidation = mock[CompanyValidation]
  val Company = new CompanyImplementation(MockingCompanyValidator)

  // Company should not be in database
  "Company " should "not in database" in {
    when(MockingCompanyValidator.companyValid(company = "Microsoft")) thenReturn false
    val result = Company.companyExist(company = "Microsoft")
    assert(result == "yes")
  }
  "Company " should "in database" in {
    when(MockingCompanyValidator.companyValid(company = "Knoldus")) thenReturn true
    val result = Company.companyExist(company = "Knoldus")
    assert(result == "no")
  }

  // Validating Email

  val MockingEmailValidation : CompanyValidation = mock[CompanyValidation]
  val EmailId = new CompanyImplementation(MockingEmailValidation)

  "Email Id" should "be valid " in {
    when(MockingEmailValidation.emailIdValid(emailId = "durgesh@gmail.com")) thenReturn true
    val result = EmailId.EmailId(email = "durgesh@gmail.com")
    assert(result == "valid")
  }
  "Email Id with wrong recipient" should "be not valid " in {
    when(MockingEmailValidation.emailIdValid(emailId = "@##durgesh@gmail.com")) thenReturn false
    val result = EmailId.EmailId(email = "@##durgesh@gmail.com")
    assert(result == "invalid")
  }
  "Email Id without @ symbol" should "be not valid " in {
    when(MockingEmailValidation.emailIdValid(emailId = "durgeshgmail.com")) thenReturn false
    val result = EmailId.EmailId(email = "durgeshgmail.com")
    assert(result == "invalid")
  }
  "Email Id with wrong domain name" should "be not valid " in {
    when(MockingEmailValidation.emailIdValid(emailId = "durgesh@##gmail.com")) thenReturn false
    val result = EmailId.EmailId(email = "durgesh@##gmail.com")
    assert(result == "invalid")
  }
  "Email Id with wrong Top level domain" should "be not valid " in {
    when(MockingEmailValidation.emailIdValid(emailId = "durgesh@gmail.ccom")) thenReturn false
    val result = EmailId.EmailId(email = "durgesh@gmail.ccom")
    assert(result == "invalid")
  }

}
