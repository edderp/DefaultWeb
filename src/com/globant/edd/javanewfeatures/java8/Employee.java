package com.globant.edd.javanewfeatures.java8;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private Integer idEmpleado;
  private String  name;
  private Integer age;
  private Double  salary;
  private Long    mobile;
  private Sexo    sexo;
  private Dependencia dependencia;
  
  public Employee(Integer idEmpleado, String name, Integer age, Double salary, Long mobile) {
    this.idEmpleado = idEmpleado;
    this.name = name;
    this.age = age;
    this.salary = salary;
    this.mobile = mobile;
  }
  
  public Employee(Integer idEmpleado, String name, Integer age, Double salary, Long mobile, Sexo sexo) {
    this.idEmpleado = idEmpleado;
    this.name = name;
    this.age = age;
    this.salary = salary;
    this.mobile = mobile;
    this.sexo = sexo;
  }

  public Employee(Integer idEmpleado, String name, Integer age, Double salary, Long mobile, Sexo sexo,
      Dependencia dependencia) {
    this.idEmpleado = idEmpleado;
    this.name = name;
    this.age = age;
    this.salary = salary;
    this.mobile = mobile;
    this.sexo = sexo;
    this.dependencia = dependencia;
  }
  
  public Integer getIdEmpleado() {
    return idEmpleado;
  }
  
  public void setIdEmpleado(Integer idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Integer getAge() {
    return age;
  }
  
  public void setAge(Integer age) {
    this.age = age;
  }
  
  public Double getSalary() {
    return salary;
  }
  
  public void setSalary(Double salary) {
    this.salary = salary;
  }
  
  public Long getMobile() {
    return mobile;
  }
  
  public void setMobile(Long mobile) {
    this.mobile = mobile;
  }
  
  public Sexo getSexo() {
    return this.sexo;
  }
  
  public void setSexo(Sexo sexo) {
    this.sexo = sexo;
  }
  
  public Dependencia getDependencia() {
    return dependencia;
  }

  public void setDependencia(Dependencia dependencia) {
    this.dependencia = dependencia;
  }

  @Override
  public String toString() {
    return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", mobile=" + mobile
        + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, dependencia, mobile, name, sexo);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Employee)) {
      return false;
    }
    Employee other = (Employee) obj;
    return Objects.equals(age, other.age) && Objects.equals(dependencia, other.dependencia)
        && Objects.equals(mobile, other.mobile) && Objects.equals(name, other.name)
        && sexo == other.sexo;
  }
  
  
  
}