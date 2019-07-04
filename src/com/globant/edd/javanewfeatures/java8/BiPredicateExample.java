package com.globant.edd.javanewfeatures.java8;

import java.util.List;
import java.util.function.BiPredicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BiPredicateExample {
  
  private static final Logger logger = LogManager.getLogger(BiPredicateExample.class);
  
  public static void main(String[] args) {
    
    List<Employee>                     listaEmpleados = ComparingExample.employees;
    
    BiPredicate<Employee, Dependencia> mayorDe30EnHr  = (t,
        u) -> t.getDependencia().getNombreDependencia().equals(u.getNombreDependencia())
            && t.getAge() > 30;
    
    Employee                           e1             = listaEmpleados.get(2);
    logger.info("Pertenece " + e1.getName() + " a Servicios generales: "
        + mayorDe30EnHr.test(e1, ComparingExample.serviciosGrales));
    logger.info(
        "Tiene Jhon Vásquez un salario menor a 4'000.000 : " + salarioMenorA4MillonesEnTecnologia()
            .test(listaEmpleados.get(5), ComparingExample.tecnologia));
  }
  
  private static BiPredicate<Employee, Dependencia> salarioMenorA4MillonesEnTecnologia() {
    return (t, u) -> t.getDependencia().getNombreDependencia().equals(u.getNombreDependencia())
        && u.getNombreDependencia().equals("Tecnología") && t.getSalary() < 4000000;
  }
}
