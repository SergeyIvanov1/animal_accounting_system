package ru.sergeyivanov.spring.rest.dao;

import ru.sergeyivanov.spring.rest.custom.InitObject;
import ru.sergeyivanov.spring.rest.custom.MyJson;

import java.util.Map;

public interface EntityDAO {

    Map<String, Integer> calculateResults();
}
