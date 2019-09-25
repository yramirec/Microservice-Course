package com.everis.model;

import java.util.Date;

import lombok.Data;

@Data
public class Student {

  private String studentId;
  private String fullName;
  private String gender;
  private Date dateOfBirth;
  private String typeDocument;
  private int numberDocument;
  private String idFamily;

}
