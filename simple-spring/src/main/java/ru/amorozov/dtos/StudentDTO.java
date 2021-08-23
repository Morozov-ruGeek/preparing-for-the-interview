package ru.amorozov.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDTO {
    private Long id;

    private String name;

    private Integer age;

    public StudentDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
