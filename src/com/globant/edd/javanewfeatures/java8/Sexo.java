package com.globant.edd.javanewfeatures.java8;

public enum Sexo {
  
  MASCULINO(0), FEMENINO(1);
  
  private final Integer identificador;
  
  Sexo(Integer i) {
    this.identificador = i;
  }
  
  public Integer getId() {
    return identificador;
  }
}