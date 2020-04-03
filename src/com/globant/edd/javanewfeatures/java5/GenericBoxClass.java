package com.globant.edd.javanewfeatures.java5;


public class GenericBoxClass {
  
  
  public static void main(String[] args) {
    System.out.println("Creando instancias genéricas para diferentes tipos:");
    System.out.println("Creando una caja para guardar Strings");
    Box<String> cajaStrings = new Box<>("String por defecto");
    cajaStrings.setInstance("Esta es una instancia de un string");
    Box<Long> cajaLongs = new Box<>(8237L);
    cajaLongs.setInstance(Long.valueOf(3456928L));
    
    System.out.println("Creando intancia genérica de par clave-valor");
    MultiTypeBox<String, Integer> stringIntBox = new MultiTypeBox<>("Clave", 1234);
    System.out.println("Clave: " + stringIntBox.getKey() + " Valor: " + stringIntBox.getValue());
    MultiTypeBox<Integer, String> intStringBox = new MultiTypeBox<>(12345, "Valor por defecto");
    System.out.println("Clave: " + intStringBox.getKey() + " Valor: " + intStringBox.getValue());
    System.out.println("Creando una caja que almacena una clase genérica");
    MultiTypeBox<String, Box<Float>> stringBoxOfFloatsBox = new MultiTypeBox<>("Clave nueva", new Box<Float>(92738f));
    System.out.println("Clave: " + stringBoxOfFloatsBox.getKey() + " Valor: " + stringBoxOfFloatsBox.getValue());
  }
  
}

class Box<T> {
  private T instance;
  
  public Box(T instance) {
    this.instance = instance;
  }

  public T getInstance() {
    return instance;
  }
  
  public void setInstance(T instance) {
    this.instance = instance;
  }

  @Override
  public String toString() {
    return "Box {instance=" + instance + "}";
  }
  
  
}

class MultiTypeBox<K, V> {
  private K key;
  private V value;
  
  public MultiTypeBox(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }
  
  public void setKey(K key) {
    this.key = key;
  }
  
  public V getValue() {
    return value;
  }
  
  public void setValue(V value) {
    this.value = value;
  }
  
}