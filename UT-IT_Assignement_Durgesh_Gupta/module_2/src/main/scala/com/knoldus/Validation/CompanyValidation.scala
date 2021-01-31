package com.knoldus.Validation

import com.knoldus.Database.CompanyData

class CompanyValidation (companyData: CompanyData)
{
  def companyValid(company: String): Boolean = {

      if(!companyData.callCompanyByName(company: String).isEmpty)
        true
      else
        false

  }
  def emailIdValid(emailId: String): Boolean ={
    """^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.)+(com|net|org)""".r.unapplySeq(emailId).isDefined
  }


}
