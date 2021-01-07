package com.example.demo;

import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SampleController {

  @Autowired
  MessageSource messagesource;

  @GetMapping("/")
  public String init(
    @ModelAttribute("sampleForm") SampleForm form,
    Model model
  ) {
    System.out.println(form);
    return "index";
  }

  @PostMapping("/")
  public String post(
    // @ModelAttribute("sampleForm") @Validated SampleForm form,
    @ModelAttribute @Validated SampleForm form,
    BindingResult bindingResult,
    Model model
  ) {
    System.out.println(form);
    if (bindingResult.hasErrors()) {
      System.out.println("** VALIDATION ERROR **");
      System.out.println(bindingResult.toString());
    }

    // getMeesage(1, 2, 3)は、メッセージがないと落ちる

    String ve1 = null;
    try {
      ve1 = messagesource.getMessage("VE001", null, Locale.getDefault());
    } catch (NoSuchMessageException ex) {
      System.out.println(ex);
    }
    String ve2 = messagesource.getMessage("VE002", null, null, Locale.getDefault());

    if (Objects.isNull(ve1)) {
      System.out.println("VE001 IS NULL");
    } else {
      System.out.println("VE001:" + ve1);
    }
    if (Objects.isNull(ve2)) {
      System.out.println("VE002 IS NULL");
    } else {
      System.out.println("VE002:" + ve2);
    }

    if (Objects.isNull(form.getAmount())) {
      String formName = bindingResult.getObjectName();
      String fieldName = "amount";
      String errorCode = "VE001";
      String messageKey = formName + "." + fieldName + "." + errorCode;

      // エラーメッセージを追加してみる
      String errorMessage = messagesource.getMessage(messageKey, null, Locale.getDefault());
      // エラーメッセージを追加する
      FieldError fieldError = new FieldError(formName, fieldName, form.getAmount(), false, null, null, errorMessage);
      bindingResult.addError(fieldError);

      System.out.println("*** SET ERROR MESSAGE:" + messageKey + " = " + errorMessage);
    }

    return "index";
  }
}
