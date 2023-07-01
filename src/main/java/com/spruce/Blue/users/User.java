package com.spruce.Blue.users;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "User name cannot be blank")
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    @NotBlank(message = "User email cannot be blank")
    private String email;

    @Column(nullable = false, length = 3)
    @Positive(message = "User age must be greater than 0")
    private int age;

    public User() {}
    public User(String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() { return age; }
}
