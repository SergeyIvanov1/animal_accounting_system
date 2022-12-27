package ru.sergeyivanov.spring.rest.custom;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyJson implements Serializable {
    private int current;
}
