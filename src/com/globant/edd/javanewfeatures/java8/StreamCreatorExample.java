package com.globant.edd.javanewfeatures.java8;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamCreatorExample {
  
  private static final Logger logger = LogManager.getLogger(StreamCreatorExample.class);
  
  public static void main(String[] args) {
    logger.info("Creando un Stream a través de una colección");
    List<Employee>   employees        = ComparingExample.employees;
    Stream<Employee> streamCollection = employees.stream();
    streamCollection.forEach(logger::info);
    logger.info("Creando un stream de un map: ");
    // Convierte una lista en un mapa usando Streams
    Map<Integer, Employee> mapaEmpleados = employees.stream().collect(Collectors.toMap(emp -> emp.getIdEmpleado(), emp -> emp));
    logger.info("Imprimiendo el mapa: ");
    mapaEmpleados.entrySet().forEach(logger::info);
    Map<Integer, String> map1 = new ConcurrentHashMap<>();
    map1.put(1, "Programmer's guide to Java");
    map1.put(2, "Hands on Full Stack Development with Spring boot 2 and react");
    map1.put(3, "Hands on Full Stack Development with Spring boot 2 and react");
    map1. put(4, "Modern Java Recipes");
    
    map1.entrySet().stream();
  }
  
}
