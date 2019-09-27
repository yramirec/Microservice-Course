package com.everis.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Course {

  @EqualsAndHashCode.Exclude
  @Id
private String id;
  
  @EqualsAndHashCode.Exclude
  @NotBlank(message = "'Name' is required")
private String name;

  @EqualsAndHashCode.Exclude
  @NotBlank(message = "'Teacher' is required")
private String idTeacher;

  @EqualsAndHashCode.Exclude
  @NotBlank(message = "'Students' is required")
private String idStudents;
  
  @EqualsAndHashCode.Exclude
  @NotBlank(message = "'Status' is required")
private String idStatus;


}
