package ru.sergeyivanov.spring.rest.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import ru.sergeyivanov.spring.rest.custom.Environment;
import ru.sergeyivanov.spring.rest.custom.InitObject;
import ru.sergeyivanov.spring.rest.custom.MyJson;
import ru.sergeyivanov.spring.rest.custom.Rules;
import ru.sergeyivanov.spring.rest.entity.Animal;

@Repository
public class EntityDAOImpl implements EntityDAO {

//    @Override
//    public MyJson addToCurrent(InitObject initObject) {
//        MyJson myJson = null;
//        int request_id = initObject.getId();
//        int add = initObject.getAdd();
//        try (Connection connection = DriverManager.getConnection(
//                Environment.DB_URL, Environment.DB_USER, Environment.DB_PASSWORD)) {
//
//            connection.setAutoCommit(false);
//            Savepoint savepoint = connection.setSavepoint();
//            Statement statement = connection.createStatement();
//
//            try {
//                statement.executeUpdate(Rules.buildQueryForUpdateCurrent(request_id, add));
//                ResultSet resultSet = statement.executeQuery(Rules.SELECT_STRINGS + " WHERE id = " + request_id);
//                resultSet.next();
//                myJson = MyJson.builder()
//                        .current(resultSet.getInt("current"))
//                        .build();
//            } catch (Exception ex) {
//                connection.rollback(savepoint);
//            }
//
//            connection.commit();
//            statement.close();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return myJson;
//    }

    @Override
    public Map<String, Integer> calculateResults() {
        Map<String, Integer> map = new HashMap<>();

        try (Connection connection = DriverManager.getConnection(
                Environment.DB_URL, Environment.DB_USER, Environment.DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            System.out.println("hello");
            ResultSet resultSet = statement.executeQuery(Rules.SELECT_HERBIVORES);
            resultSet.next();
                map.put(Rules.name, resultSet.getInt("count"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
