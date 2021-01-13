package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatternController {
  @GetMapping("/pattern")
  public String init(
    @ModelAttribute("patternData") @Validated PatternData patternData,
    BindingResult bindingResult
  ) {
    System.out.println(patternData.toString());
    return "pattern";
  }

}
