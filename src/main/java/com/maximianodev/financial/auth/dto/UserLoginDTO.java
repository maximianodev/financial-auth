package com.maximianodev.financial.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {
  private String email;
  private String password;
}
