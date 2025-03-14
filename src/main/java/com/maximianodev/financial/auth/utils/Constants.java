package com.maximianodev.financial.auth.utils;

import java.time.Duration;

public class Constants {
  public static class ErrorMessages {
    public static final String ERROR_GENERIC = "Internal Server Error";
    public static final String ERROR_BAD_REQUEST = "Bad Request";
    public static final String ERROR_INVALID_EMAIL = "Invalid Email";
    public static final String ERROR_INVALID_PASSWORD = "Invalid Password";
    public static final String ERROR_INVALID_NAME = "Invalid Name";
    public static final String ERROR_SENDING_EMAIL = "Error sending email";
    public static final String ERROR_EXPIRED_TOKEN = "Token has expired";
  }

  public static class SuccessMessages {
    public static final String SUCCESS_USER_REGISTERED = "User registered successfully";
    public static final String SUCCESS_USER_LOGGED_IN = "User logged in successfully";
    public static final String SUCCESS_USER_LOGGED_OUT = "User logged out successfully";
    public static final String SUCCESS_PASSWORD_RESET_LINK_SENT =
        "Password reset link sent to your email";
    public static final String SUCCESS_PASSWORD_RESET = "Password reset successfully";
  }

  public static class Email {
    public static final String RECOVERY_MESSAGE_TITLE = "Clique aqui %s/reset-password?token=%s";
    public static final String RECOVERY_MESSAGE_CONTENT = "Clique aqui %s/reset-password?token=%s";
  }

  public static class Cookies {
    public static final String AUTH_COOKIE_NAME = "Authorization";
    public static final String AUTH_COOKIE_PATH = "/";
    public static final boolean AUTH_COOKIE_HTTP_ONLY = true;
    public static final long AUTH_COOKIE_MAX_AGE = Duration.ofDays(1).getSeconds();
  }
}
