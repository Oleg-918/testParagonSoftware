package com.example.testparagonsoftware.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    @NotBlank
    @Email
    private String email;

    @Column(name = "name")
    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @Column(name = "phone_number")
    @Size(min = 10, max = 12)
    private String phoneNumber;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "The field should not be empty")
    private UserStatusEnum status;

}
