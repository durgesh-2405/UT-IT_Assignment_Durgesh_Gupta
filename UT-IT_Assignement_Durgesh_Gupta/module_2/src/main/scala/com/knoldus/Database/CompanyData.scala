package com.knoldus.Database

import com.knoldus.Model.CompanyMod

import scala.collection.immutable.HashMap

class CompanyData {
  val companyKnoldus: CompanyMod = CompanyMod("Knoldus", "knoldus@knoldus.com","Noida")
  val companyGoogle: CompanyMod = CompanyMod("Google", "google@google.com", "Banglore")
  val companies: HashMap[String, CompanyMod] = HashMap("Knoldus" -> companyKnoldus, "Google" -> companyGoogle)

  def callCompanyByName(name: String): Option[CompanyMod] = companies.get(name)

}
