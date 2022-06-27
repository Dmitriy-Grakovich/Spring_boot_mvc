package ru.grakovich.spring_boot.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Not null")
    @Size(min = 2, max = 30, message = "")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Not null")
    @Size(min = 2, max = 30, message = "")
    @Column(name = "lastName")
    private String lastName;

    @Min(value = 0, message = " > 0")
    @Max(value = 130, message = "<130")
    @Column(name = "age")
    private Integer age;

    @Override
    public String toString() {
        return id + " | " + name + " | " + lastName + " | " + age + " |";
    }
}
