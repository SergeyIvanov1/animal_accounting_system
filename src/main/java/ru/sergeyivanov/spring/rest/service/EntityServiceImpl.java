package ru.sergeyivanov.spring.rest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sergeyivanov.spring.rest.custom.InitObject;
import ru.sergeyivanov.spring.rest.custom.MyJson;
import ru.sergeyivanov.spring.rest.dao.EntityDAO;
import ru.sergeyivanov.spring.rest.dao.EntityDAOImpl;

import java.util.Map;

@Service
public class EntityServiceImpl implements EntityService {

    EntityDAO myEntityDAO = new EntityDAOImpl();

    @Override
    public Map<String, Integer> calculateResults() {
        return myEntityDAO.calculateResults();
    }
}
