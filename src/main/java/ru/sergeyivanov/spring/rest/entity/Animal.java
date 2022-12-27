package ru.sergeyivanov.spring.rest.entity;

import ru.sergeyivanov.spring.rest.custom.MyJson;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animal implements Serializable {
    private Long id;
    private String weight;
    private String height;
    private String typeOfAnimal;
}
