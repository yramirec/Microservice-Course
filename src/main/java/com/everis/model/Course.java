package com.everis.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
  @NotBlank(message = "'Teacher' is required")
private String idTeacher;

  @EqualsAndHashCode.Exclude
  @NotBlank(message = "'Students' is required")
private Student student;


}
