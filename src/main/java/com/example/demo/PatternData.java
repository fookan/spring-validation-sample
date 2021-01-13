package com.example.demo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatternData {
  @Pattern(regexp = Regexp.VALIDATION_TEXT_FILE)
  private String fileName;
  @Pattern(regexp = Regexp.VALIDATION_NUMBER)
  private String number;
  @Pattern(regexp = Regexp.VALIDATION_DATE)
  private String date;
  @Pattern(regexp = Regexp.VALIDATION_DATE_TIME)
  private String dateTime;
  @Size(min = 1, max = 20)
  private String test;
}
