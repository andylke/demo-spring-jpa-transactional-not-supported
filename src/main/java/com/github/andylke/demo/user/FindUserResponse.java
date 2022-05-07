package com.github.andylke.demo.user;

import java.time.LocalDateTime;

public class FindUserResponse {

  private String gender;

  private String title;

  private String firstName;

  private String lastName;

  private String email;

  private String nationality;

  private LocalDateTime lastCredentialsChangeDateTime;

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public LocalDateTime getLastCredentialsChangeDateTime() {
    return lastCredentialsChangeDateTime;
  }

  public void setLastCredentialsChangeDateTime(LocalDateTime lastCredentialsChangeDateTime) {
    this.lastCredentialsChangeDateTime = lastCredentialsChangeDateTime;
  }
}
