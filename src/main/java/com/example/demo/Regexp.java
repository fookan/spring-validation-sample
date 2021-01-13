package com.example.demo;

public class Regexp {
  public static final String VALIDATION_TEXT_FILE = "^.+\\.[tT][xX][tT]$";
  public static final String VALIDATION_NUMBER = "^[0-9]*$";
  public static final String VALIDATION_DATE =      "^\\d{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$";
  public static final String VALIDATION_DATE_TIME = "^\\d{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9]$";
}
