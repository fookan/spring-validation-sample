package com.example.demo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.boot.convert.DataSizeUnit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleForm {
  @NotEmpty
  @Size(min = 1, max = 2, message = "{VE001}")
  @Pattern(regexp = "^[a-z]*$", message = "直接書きました")
  private String code;

  // 全角数字も数字とみなされる
  @Min(10)
  @Max(100)
  // @Pattern(regexp = "^[0-9]*$") Integer/intには使えない
  private int number;

  // 全角数字も数字とみなされる
  @Range(min = 1, max = 5, message="{sampleForm.number2.VE003}")
  private int number2;

  // 空を許す数字はプリミティブ型じゃなくクラス型にする
  @Range(min = 1, max = 10, message ="{sampleForm.amount.VE001}")
  private Integer amount;
}
