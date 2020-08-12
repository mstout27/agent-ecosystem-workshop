package com.contrastsecurity;

import org.apache.commons.text.CaseUtils;

public class HelloWorld{
  public static void main(String[] args){
    String string = "java-programming-language";

// Capitalizes the first letter
    System.out.println(CaseUtils.toCamelCase(string, true, '-'));
// Does not capitalize the first letter
    System.out.println(CaseUtils.toCamelCase(string, false, '-'));
  }
}