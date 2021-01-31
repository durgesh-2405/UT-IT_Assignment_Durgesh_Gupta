package com.knoldus.Validation

class EmailValidation {
  def emailCheck(emailId: String): Boolean = {
    """^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.)+(com|net|org)""".r.unapplySeq(emailId).isDefined
  }

}
