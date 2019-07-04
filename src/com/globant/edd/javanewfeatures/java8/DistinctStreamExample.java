package com.globant.edd.javanewfeatures.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DistinctStreamExample {
  
  private static final Logger logger = LogManager.getLogger(DistinctStreamExample.class);
  
  public static void main(String[] args) {
    
    Supplier<List<Integer>> supplier   = () -> {
                                         List<Integer> retorno = new ArrayList<>();
                                         for (int i = 1; i <= 100; i++) {
                                           retorno.add(new Random().nextInt(100));
                                         }
                                         return retorno;
                                       };
    
    List<Integer>           aleatorios = supplier.get();
    
    logger.info("Total de números generados: " + aleatorios.size());
    logger.info("Total de números distintos: " + aleatorios.stream().distinct().count());
    
    Stream<String> combinacionesRepetidas = Stream.of("AA", "BB", "CC", "BB", "AB", "CB", "aa",
        "CC", "AC", "BC", "AA");
    logger.info("Resultado: " + combinacionesRepetidas.distinct().collect(Collectors.joining(",")));
    
    Supplier<List<Employee>> employeeSupplier = () -> {
      List<Employee> listaEmp = new ArrayList<>();
      listaEmp.add(new Employee(12, "Miguel Estrada", 39, 832000.0, 3056667722L, Sexo.MASCULINO,
          ComparingExample.serviciosGrales));
      listaEmp.add(new Employee(13, "Carolina Montoya", 27, 3200000.0, 3004447722L, Sexo.FEMENINO,
          ComparingExample.hr));
      listaEmp.add(new Employee(14, "Miguel Estrada", 39, 832000.0, 3056667722L, Sexo.MASCULINO,
          ComparingExample.serviciosGrales));
      listaEmp.add(new Employee(15, "Luis Mendieta", 26, 3200000.0, 3138187722L, Sexo.MASCULINO,
          ComparingExample.tecnologia));
      listaEmp.add(new Employee(16, "Carolina Montoya", 27, 3200000.0, 3004447722L, Sexo.FEMENINO,
          ComparingExample.hr));
      listaEmp.add(new Employee(17, "Miguel Estrada", 39, 832000.0, 3056667722L, Sexo.MASCULINO,
          ComparingExample.serviciosGrales));
      listaEmp.add(new Employee(18, "Pedro Conde", 46, 2500000.0, 3105761100L, Sexo.MASCULINO,
          ComparingExample.serviciosGrales));
      
      return listaEmp;
    };
    
    logger.info("Lista con elementos repetidos: ");
    employeeSupplier.get()
        .forEach(e -> logger.info(e.getName() + " " + e.getDependencia().getNombreDependencia()));
    logger.info("Lista sin elementos repetidos: ");
    employeeSupplier.get().stream().distinct()
        .forEach(e -> logger.info(e.getName() + " " + e.getDependencia().getNombreDependencia()));
  }
}
