package ru.sergeyivanov.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sergeyivanov.spring.rest.exception_handling.EntityIncorrectData;
import ru.sergeyivanov.spring.rest.exception_handling.NoSuchEntityException;
import ru.sergeyivanov.spring.rest.service.EntityService;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EntityService entityService;

    @GetMapping("/results")
    public Map<String, Integer> getRulesWithResults(){
        Map<String, Integer> results = entityService.calculateResults();

        if (results == null){
            throw new NoSuchEntityException("Operation failed");
        }
        return results;
    }

    @ExceptionHandler
    public ResponseEntity<EntityIncorrectData> handleException(NoSuchEntityException exception){
        EntityIncorrectData data = new EntityIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EntityIncorrectData> handleException(Exception exception){
        EntityIncorrectData data = new EntityIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
