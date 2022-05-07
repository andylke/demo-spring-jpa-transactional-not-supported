package com.github.andylke.demo.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserCredentials {

  @Id private String username;

  private String password;

  private LocalDateTime lastChangeDateTime;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LocalDateTime getLastChangeDateTime() {
    return lastChangeDateTime;
  }

  public void setLastChangeDateTime(LocalDateTime lastChangeDateTime) {
    this.lastChangeDateTime = lastChangeDateTime;
  }
}
