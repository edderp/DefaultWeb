package com.globant.edd.javanewfeatures.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ComparingExample {
  
  private static final Logger     logger = LogManager.getLogger(ComparingExample.class);
  
  protected static List<Employee> employees;
  protected static Dependencia hr;
  protected static Dependencia tecnologia;
  protected static Dependencia serviciosGrales;
  
  static {
    hr = new Dependencia(1, "Recursos humanos");
    tecnologia = new Dependencia(2, "Tecnología");
    serviciosGrales = new Dependencia(3, "Servicios generales");
    employees = new ArrayList<>();
    employees.add(new Employee(1, "Carlos Peña", 48, 832000.0, 3134458219L, Sexo.MASCULINO, serviciosGrales));
    employees.add(new Employee(2, "María González", 31, 1600000.0, 3186752935L, Sexo.FEMENINO, hr));
    employees.add(new Employee(3, "Gabriel Ortega", 35, 3500000.0, 3502856616L, Sexo.MASCULINO, tecnologia));
    employees.add(new Employee(4, "Danit Medina", 29, 6823999.0, 3012378121L, Sexo.FEMENINO, hr));
    employees.add(new Employee(5, "Dayanara Torres", 21, 832000.0, 3123234312L, Sexo.FEMENINO, serviciosGrales));
    employees.add(new Employee(6, "Jhon Vásquez", 34, 5500000.0, 3112960882L, Sexo.MASCULINO, tecnologia));
    employees.add(new Employee(7, "Daniel Solano", 31, 4950000.0, 3508523718L, Sexo.MASCULINO, tecnologia));
    employees.add(new Employee(8, "Francisco Sánchez", 60, 1200000.0, 3016664432L, Sexo.MASCULINO, serviciosGrales));
  }
  
  public static void main(String[] args) {
    Consumer<Employee> consumer = c -> logger.info(c);
    
    logger.info("Se imprime la lista employees");
    employees.forEach(e -> consumer.accept(e));
    List<Employee> sortedEmployeesByName = employees;
    Collections.sort(sortedEmployeesByName, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    logger.info("Se procede a imprimir la lista sortedEmployeesByName");
    sortedEmployeesByName.forEach(e -> consumer.accept(e));
    List<Employee> sortedEmployeesByNameDesc = employees;
    Collections.sort(sortedEmployeesByNameDesc, (p1, p2) -> p2.getName().compareTo(p1.getName()));
    logger.info("Se procede a imprimir la lista sortedEmployeesByNameDesc");
    sortedEmployeesByNameDesc.forEach(e -> consumer.accept(e));
    List<Employee> sortedEmployeesByAge = employees;
    Collections.sort(sortedEmployeesByAge, (p1, p2) -> p1.getAge().compareTo(p2.getAge()));
    logger.info("Se procede a imprimir la lista sortedEmployeesByAge");
    sortedEmployeesByAge.forEach(e -> consumer.accept(e));
    
  }
}