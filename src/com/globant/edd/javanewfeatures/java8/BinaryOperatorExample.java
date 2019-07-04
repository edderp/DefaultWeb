package com.globant.edd.javanewfeatures.java8;

import java.util.Random;
import java.util.function.DoubleBinaryOperator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinaryOperatorExample {
  
  private static final Logger logger = LogManager.getLogger(BinaryOperatorExample.class);
  
  public static void main(String[] args) {
    
    Random r = new Random(new java.util.Date().getTime());
    Double o1 = (double) r.nextInt(100);
    Double o2 = (double) r.nextInt(100);
    
    DoubleBinaryOperator suma = (d1, d2) -> d1+d2;
    DoubleBinaryOperator resta = (d1, d2) -> d1-d2;
    DoubleBinaryOperator multiplicacion = (d1, d2) -> d1*d2;
    DoubleBinaryOperator division = (d1, d2) -> {
      if (d2 != 0.0) return d1/d2; else {throw new ArithmeticException("No se puede dividir por cero (0)");}
    };
    
    logger.info(o1 + " + " + o2 + " = " + suma.applyAsDouble(o1, o2));
    logger.info(o1 + " - " + o2 + " = " + resta.applyAsDouble(o1, o2));
    logger.info(o1 + " * " + o2 + " = " + multiplicacion.applyAsDouble(o1, o2));
    logger.info(o1 + " / " + o2 + " = " + division.applyAsDouble(o1, o2));
  }
}

