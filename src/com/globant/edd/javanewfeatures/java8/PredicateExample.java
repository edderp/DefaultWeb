package com.globant.edd.javanewfeatures.java8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PredicateExample {
  
  private static final Logger logger = LogManager.getLogger(PredicateExample.class);
  
  public static void main(String[] args) {
    List<Employee> empleados = ComparingExample.employees;
    
    empleados.stream().forEach(logger::info);
    // Prueba y filtrado a través de stream y Lambda expressions
    logger.info("Número de empleados hombres mayores de edad: {}", empleados.stream()
        .filter(e -> e.getAge() > 21 && e.getSexo().equals(Sexo.MASCULINO)).count());
    logger.info("Número de empleadas mujeres mayores de edad: {}", empleados.stream().filter(isMujerAdulta()).count());
    logger.info("Primer empleado mayor de 30 en la lista: {}", empleados.stream().filter(edadMayorQue(30)).findFirst());
    logger.info("Mujeres en la empresa: {}", empleados.stream().filter(isMujerAdulta()).collect(Collectors.toList()));
    logger.info("Total de salarios pagados en la empresa: {}", empleados.stream().mapToDouble(e -> e.getSalary()).sum());
    logger.info("{}", empleados.stream().filter(edadMayorQue(30).negate()).findAny());
  }
  
  public static List<Employee> filtrarEmpleados(List<Employee> empleados,
      Predicate<Employee> predicate) {
    return empleados.stream().filter(predicate).collect(Collectors.toList());
  }
  
  // Interfaz funcional
  public static Predicate<Employee> isMujerAdulta() {
    return t -> t.getSexo() == Sexo.FEMENINO && t.getAge() > 21;
  }
  
  public static Predicate<Employee> edadMayorQue(int edad) {
    return t -> t.getAge() > edad;
  }
  
}
