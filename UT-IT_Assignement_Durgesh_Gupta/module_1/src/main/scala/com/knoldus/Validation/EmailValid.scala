package com.knoldus.Validation


class EmailValid {
  def ifValid(email:String): Boolean={
    """^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.)+(com|net|org)""".r.unapplySeq(email).isDefined
  }

}
