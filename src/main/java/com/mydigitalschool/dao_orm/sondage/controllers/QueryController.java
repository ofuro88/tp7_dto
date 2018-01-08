package com.mydigitalschool.dao_orm.sondage.controllers;

import com.mydigitalschool.dao_orm.sondage.dtos.Question;
import com.mydigitalschool.dao_orm.sondage.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(QueryController.ENDPOINT)
public class QueryController {
    protected static final String ENDPOINT = "/api/queries";

    @Autowired
    QuestionService questionService;

    @GetMapping("")
    public String home() {
        return "Queries home";
    }

    @GetMapping("/questions")
    public List<Question> questions() {
        return questionService.getQuestions();
    }

    @GetMapping("/options-by-question")
    public List<Question> qestionOptions() {
        return questionService.getQuestions();
    }
}
