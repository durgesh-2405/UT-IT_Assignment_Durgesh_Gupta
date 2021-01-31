package com.knoldus.Validation


import com.knoldus.Implementation.eMailInput
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class Email_Test extends AsyncFlatSpec{
  val MockingValidation: EmailValid = mock(classOf[EmailValid])
  val emailId = new eMailInput(MockingValidation)

  // Unit Test cases for Validation of Email

  "Email Id" should "be Valid" in {
    when(MockingValidation.ifValid(email = "durgesh@yahoo.net")) thenReturn true
    val result = emailId.eMail(email = "durgesh@yahoo.net")
    assert(result=="yes")
  }
  "Email Id with wrong Recipient name" should "be invalid" in {
    when(MockingValidation.ifValid(email = "# #durgesh@yahoo.net")) thenReturn false
    val result = emailId.eMail(email = "# #durgesh@yahoo.net")
    assert(result=="no")
  }
  "Email Id missing @ symbol" should "be invalid" in {
    when(MockingValidation.ifValid(email = "durgeshyahoo.com")) thenReturn false
    val result = emailId.eMail(email = "durgeshyahoo.com")
    assert(result=="no")
  }
  "Email Id with wrong domain name" should "be invalid" in {
    when(MockingValidation.ifValid(email = "durgesh@!yahoo.com")) thenReturn false
    val result = emailId.eMail(email = "durgesh@!yahoo.com")
    assert(result=="no")
  }
  "Email Id with wrong Top_Level Domain Name" should "be invalid" in {
    when(MockingValidation.ifValid(email = "durgesh@yahoo.ccom")) thenReturn false
    val result = emailId.eMail(email = "durgesh@yahoo.ccom")
    assert(result=="no")
  }



}
