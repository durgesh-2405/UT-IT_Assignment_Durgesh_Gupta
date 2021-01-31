package com.knoldus.Implementation

import com.knoldus.Validation.CompanyValidation

class CompanyImplementation (companyValid: CompanyValidation){
  val CompanyAvail = "no"
  val CompanyNotAvail = "yes"
  val EmailAvail = "valid"
  val EmailNotAvail = "invalid"

  def companyExist(company: String): String = {
    if (companyValid.companyValid(company: String))
      {
        println("Company exists")
        CompanyAvail
      }
    else {
      println("Company does not exists")
      CompanyNotAvail
    }
  }
 def EmailId(email: String): String = {
   if (companyValid.emailIdValid(email))
     {
       println("Enail Valid")
       EmailAvail
     }
   else
   {
     println("Email not valid")
     EmailNotAvail
   }
 }
}
