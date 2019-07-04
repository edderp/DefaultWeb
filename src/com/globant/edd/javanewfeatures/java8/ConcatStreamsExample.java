package com.globant.edd.javanewfeatures.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConcatStreamsExample {
  
  private static final Logger logger   = LogManager.getLogger(ConcatStreamsExample.class);
  protected static String[]      manuales = { "Manual de funciones", "Manual de salud y seguridad",
      "Reglamento interno", "Contrato individual" };
  protected static String[]      libros   = { "El capital humano de las organizaciones",
      "Empresa y gestión de recursos humanos", "Reglamento electrotécnico" };
  
  public static void main(String[] args) {
    List<Employee> nuevosEmpleados = new ArrayList<>();
    logger.info("Empleados antiguos: ");
    ComparingExample.employees.forEach(logger::info);
    nuevosEmpleados
        .add(new Employee(9, "Maritza Gutiérrez", 18, 416000.0, 3142364421L, Sexo.FEMENINO));
    nuevosEmpleados.add(new Employee(10, "Bryan Perea", 20, 832000.0, 3103612914L, Sexo.MASCULINO));
    nuevosEmpleados.add(new Employee(11, "Teresa Pérez", 44, 10500000.0, 3119271834L, Sexo.FEMENINO));
    
    logger.info("Nuevos empleados: ");
    nuevosEmpleados.forEach(logger::info);
    List<Employee> totalEmpleados = Stream
        .concat(ComparingExample.employees.stream(), nuevosEmpleados.stream())
        .collect(Collectors.toList());
    logger.info("Total de empleados: ");
    totalEmpleados.forEach(e -> logger.info(e.getName() + " " + e.getAge() + " " + e.getSalary()));
    
    Stream<String> m = Stream.of(manuales);
    Stream<String> l = Stream.of(libros);
    logger.info("Manuales: ");
    m.forEach(logger::info);
    logger.info("Libros: ");
    l.forEach(logger::info);
    String[] biblioteca = (String[]) Stream.concat(m, l).toArray();
    Stream.of(biblioteca).forEach(logger::info);
  }
}
