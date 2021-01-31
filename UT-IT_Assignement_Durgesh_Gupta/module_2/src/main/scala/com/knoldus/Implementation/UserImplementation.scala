package com.knoldus.Implementation

import com.knoldus.Validation.UserValidation

class UserImplementation (userValid: UserValidation){
  val CompanyAvail = "yes"
  val CompanyNotAvail= "no"
  val ValidEmail = "valid"
  val NotValidEmail = "invalid"

  def companyExist(company: String): String = {
    if (userValid.companyValid(company: String)) {
      println("Company Exists")
      CompanyAvail
    }
    else {
      println("Company does not exists")
      CompanyNotAvail

    }
  }
  def emailId(email: String): String = {
    if (userValid.emailValid(email)) {
      println("Email is Valid")
      ValidEmail
      }
    else {
      println("Email not valid")
      NotValidEmail
    }
  }
}
