package com.knoldus.Implementation

import com.knoldus.Validation.EmailValid

class eMailInput (validMail: EmailValid){
  val emailvalid = "yes"
  val emailnotvalid = "no"
  def eMail(email : String) :String = {
    if (validMail.ifValid(email))
      {
        println("Email is Valid")
        emailvalid
      }
    else
      {
        println("Email not valid")
        emailnotvalid
      }
  }


}
