package com.globant.edd.javanewfeatures.java8;

import java.io.Serializable;
import java.util.Objects;

public class Dependencia implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 6053069092925459721L;
  
  private Integer dependenciaId;
  private String nombreDependencia;
  
  public Dependencia(Integer dependenciaId, String nombreDependencia) {
    this.dependenciaId = dependenciaId;
    this.nombreDependencia = nombreDependencia;
  }
  
  public Integer getDependenciaId() {
    return dependenciaId;
  }
  
  public void setDependenciaId(Integer dependenciaId) {
    this.dependenciaId = dependenciaId;
  }
  
  public String getNombreDependencia() {
    return nombreDependencia;
  }
  
  public void setNombreDependencia(String nombreDependencia) {
    this.nombreDependencia = nombreDependencia;
  }
  

  @Override
  public int hashCode() {
    return Objects.hash(dependenciaId, nombreDependencia);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Dependencia)) {
      return false;
    }
    Dependencia other = (Dependencia) obj;
    return Objects.equals(dependenciaId, other.dependenciaId)
        && Objects.equals(nombreDependencia, other.nombreDependencia);
  }
  
  
}
