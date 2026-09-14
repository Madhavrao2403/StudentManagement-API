package com.mini.StudentManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    @Size(min = 3,max=20)
    private String name;

    @Column
    @NotBlank
    private String email;

    @Column
    @NotNull
    @Positive
    private Integer age;

    @Column
    @NotBlank
    private String department;

    @Column
    @NotBlank
    private String course;

    @Column
    @Size(min=10,max=12)
    private String phonenumber;
}
