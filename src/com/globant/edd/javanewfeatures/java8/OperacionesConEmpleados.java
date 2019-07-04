package com.globant.edd.javanewfeatures.java8;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OperacionesConEmpleados {
  
  private static final Logger logger = LogManager.getLogger(OperacionesConEmpleados.class);
  
  public static void main(String[] args) {
    List<Employee> empleados = ComparingExample.employees;
    logger.info("Lista de empleados con salario sin descuentos: ");
    empleados.forEach(e-> logger.info(e.getName()+ " " + e.getSalary()));
    new OperacionesConEmpleados().descontarSaludYPension(empleados);    
  }
  
  private void descontarSaludYPension(List<Employee> empleados) {
    logger.info("Empleados con su salario descontado");
    empleados.forEach(e-> {
      e.setSalary(e.getSalary()*0.92);
      logger.info(e.getName() + " " + e.getSalary());
    });
  }
}
