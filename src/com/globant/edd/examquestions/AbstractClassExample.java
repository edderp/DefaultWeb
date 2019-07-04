package com.globant.edd.examquestions;

abstract class Writer {
  
  public static void write() {
    System.out.println("Writing...");
  }
}

class Author extends Writer {
  
  public Author() {
    
  }
  
  public static void write() {
    System.out.println("Writing book...");
  }
}

public class AbstractClassExample extends Writer {
  
  public static void write() {
    System.out.println("Writing code...");
  }
  
  public static void main(String[] args) {
    Writer.write();
  }
  
}
