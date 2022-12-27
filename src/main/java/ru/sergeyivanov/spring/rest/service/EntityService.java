package ru.sergeyivanov.spring.rest.service;

import ru.sergeyivanov.spring.rest.custom.InitObject;
import ru.sergeyivanov.spring.rest.custom.MyJson;

import java.util.Map;

public interface EntityService {

    public Map<String, Integer> calculateResults();
}
