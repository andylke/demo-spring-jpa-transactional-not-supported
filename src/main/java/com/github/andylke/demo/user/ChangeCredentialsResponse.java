package com.github.andylke.demo.user;

import java.time.LocalDateTime;

public class ChangeCredentialsResponse {

  private LocalDateTime lastCredentialsChangeDateTime;

  public LocalDateTime getLastCredentialsChangeDateTime() {
    return lastCredentialsChangeDateTime;
  }

  public void setLastCredentialsChangeDateTime(LocalDateTime lastCredentialsChangeDateTime) {
    this.lastCredentialsChangeDateTime = lastCredentialsChangeDateTime;
  }
}
