package com.knoldus.Implementation

import com.knoldus.Model.EmployeeMod
import com.knoldus.Validation.EmployeeValidation

class EmployeeImplementation (employeeValidator: EmployeeValidation){
  def createEmployee(employee: EmployeeMod): Option[String] = {
    if(employeeValidator.employeeValid(employee)) Option(employee.emailId)
    else None
  }

}
