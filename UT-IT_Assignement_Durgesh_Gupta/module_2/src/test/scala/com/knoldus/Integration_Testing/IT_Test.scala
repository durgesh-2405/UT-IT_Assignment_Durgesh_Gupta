package com.knoldus.Integration_Testing

import com.knoldus.Database.CompanyData
import com.knoldus.Implementation.{CompanyImplementation, UserImplementation, EmailImplementation}
import com.knoldus.Validation.{CompanyValidation, EmailValidation, UserValidation}
import org.scalatest.flatspec.AsyncFlatSpec

class IT_Test extends AsyncFlatSpec{

  // Testing CompanyImplementation and CompanyValidation
  val companyData = new CompanyData()
  val companyValidator: CompanyValidation = new CompanyValidation(companyData)
  val companyImpl = new CompanyImplementation(companyValidator)

  // Company should exists in database
  "Company" should "exists in Database" in {
    val result = companyImpl.companyExist(company = "Knoldus")
    assert(result=="no")
  }
  "Company" should "not exists in Database" in {
    val result = companyImpl.companyExist(company = "Microsoft")
    assert(result == "yes")
  }
  // Email Validation
  "Email Id " should "be valid " in {
    val result= companyImpl.EmailId(email="durgesh@gmail.com")
    assert(result == "valid")
  }
  "Email Id with wrong recipient" should "be not valid" in {
    val result = companyImpl.EmailId(email = "!!durgesh@gmail.com")
    assert(result=="invalid")
  }
  // Testing the UserImplementation and User Validation
  val userValidator: UserValidation = new UserValidation(companyData)
  val userImpl = new UserImplementation(userValidator)

  // Check for company
  "A Company" should "exists in Database" in {
    val result = userImpl.companyExist(company = "Knoldus")
    assert(result=="yes")
  }
  "A Company" should "not exists in Database" in {
    val result = userImpl.companyExist(company = "Microsoft")
    assert(result == "no")
  }

  // Email Validation
  "Email Id without @" should "will be invalid " in {
    val result= userImpl.emailId(email="durgeshgmail.com")
    assert(result == "invalid")
  }
  "Email Id with wrong domain name" should "be not valid" in {
    val result = userImpl.emailId(email = "durgesh@agy!.com")
    assert(result=="invalid")
  }
  // Testing the Email Validator

  val emailValidator: EmailValidation = new EmailValidation
  val emailImpl = new EmailImplementation(emailValidator)

  // Email Validation
  "Email Id with wrong top level domain name" should "be not valid" in {
    val result = emailImpl.callEmailId(email = "durgesh@agy!.com")
    assert(result == "no")
  }


}
