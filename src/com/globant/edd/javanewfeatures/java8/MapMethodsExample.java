package com.globant.edd.javanewfeatures.java8;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MapMethodsExample {
 
  private static final Logger logger = LogManager.getLogger(MapMethodsExample.class);
  
  public static void main(String[] args) {
    
    Map<Integer, String> map = crearMapa().get();
    
    logger.info("Iterando usando un iterador " + LocalDateTime.now());
    Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
    while (it.hasNext()) {
      Entry<Integer, String> entry = it.next();
      logger.info(entry.getKey() + " : " + entry.getValue());
    }
    
    logger.info("Iteramos el mapa usando un ciclo for-each " + LocalDateTime.now());
    for (Entry<Integer, String> entry : map.entrySet()) {
      logger.info(entry.getKey() + " : " + entry.getValue());
    }
    
    logger.info("Iteramos usando un stream " + LocalDateTime.now());
    map.entrySet().stream().forEach(entry -> logger.info(entry.getKey() + " " + entry.getValue()));
    logger.info("Fin: " + LocalDateTime.now());
    
    logger.info("Imprimiendo los diferentes que son " + map.values().stream().distinct().count());
    map.values().stream().distinct().sorted().forEach(logger::info);
    
    logger.info("Probando el método Map.compute(): ");
    Integer llaveAleatoria = new Random().nextInt(100);
    map.compute(llaveAleatoria, (key, value) -> key > 50?value.concat("mayor"): value.concat("menor"));
    logger.info("llaveAleatoria: " + llaveAleatoria + " resultado: " + map.get(llaveAleatoria));
    logger.info("Probando el método Map.computeIfAbsent() con una llave mayor a 100: ");
    map.computeIfAbsent(101, k -> "Nuevo valor");
    logger.info("Key: 101 Value: "+map.get(101));
    logger.info("Probando el método Map.computeIfPresent() con una llave aleatoria: ");
    llaveAleatoria = new Random().nextInt(100);
    map.computeIfPresent(llaveAleatoria, (k, v) -> v = "1000000");
    logger.info("llaveAleatoria: " + llaveAleatoria + " valor: " + map.get(llaveAleatoria));
  }
  
  private static Supplier<Map<Integer, String>> crearMapa() {
    return () -> {
      List<String> values = Stream.generate(() -> "" + new Random().nextInt(100)).limit(100).collect(Collectors.toList());
      Map<Integer, String> m1 = new ConcurrentHashMap<>();
      
      for(int i = 0; i < values.size(); i++) {
        m1.put(i, values.get(i));
      }
      return m1;
    };
  }
}
