package com.knoldus.Implementation

import com.knoldus.Validation.EmailValidation

class EmailImplementation(emailValidator: EmailValidation){
  val VerifiedEmail = "yes"
  val UnVerifiedEmail = "no"

  def callEmailId(email :String) :String ={
    if(emailValidator.emailCheck(email)) {
      println("Valid Email")
      VerifiedEmail
    }
    else
      {
        println("Invalid Email")
        UnVerifiedEmail
      }


  }

}
