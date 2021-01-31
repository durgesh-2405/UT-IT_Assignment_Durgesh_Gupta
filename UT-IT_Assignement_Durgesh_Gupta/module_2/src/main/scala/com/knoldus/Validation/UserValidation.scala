package com.knoldus.Validation

import com.knoldus.Database.CompanyData

class UserValidation (companyData: CompanyData){
  def companyValid(company: String): Boolean = {
    if(companyData.callCompanyByName(company: String).isEmpty)
      false
    else
      true
  }
  def emailValid(emailId: String): Boolean = {
    """^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.)+(com|net|org)""".r.unapplySeq(emailId).isDefined
  }

}
