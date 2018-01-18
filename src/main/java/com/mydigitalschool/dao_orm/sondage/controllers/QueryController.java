package com.mydigitalschool.dao_orm.sondage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mydigitalschool.dao_orm.sondage.dtos.Item;
import com.mydigitalschool.dao_orm.sondage.dtos.Participant;
import com.mydigitalschool.dao_orm.sondage.dtos.Question;
import com.mydigitalschool.dao_orm.sondage.dtos.Reponse;
import com.mydigitalschool.dao_orm.sondage.services.ItemService;
import com.mydigitalschool.dao_orm.sondage.services.ParticipantService;
import com.mydigitalschool.dao_orm.sondage.services.QuestionService;

@RestController
@RequestMapping(QueryController.ENDPOINT)
public class QueryController {
    protected static final String ENDPOINT = "/api/queries";

    @Autowired
    QuestionService questionService;
    
    @Autowired
    ParticipantService participantService;

    @Autowired
    ItemService itemService;
    
    @Autowired
    ReponseService reponseService;
    
    @GetMapping("")
    public String home() {
        return "Queries home";
    }

    @GetMapping("/questions")
    public List<Question> questions() {
        return questionService.getQuestions();
    }
    
    @GetMapping("/number-of-questions")
    public int numberOfQuestions() {
    	return questionService.getNumberOfQuestions();
    }
    
    @GetMapping("/number-of-participants")
    public int numberOfParticipants() {
    	return participantService.getNumberOfParticipants();
    }

    @GetMapping("/participants")
    public List<Participant> participants(){
    	return participantService.getParticipants();
    }
    
    @GetMapping("/options-by-question")
    public Question questionOptions(Integer questionId) {
        return questionService.getQuestionsById(questionId);
    }
    
    @GetMapping("/options-by-participant")
    public Participant participantOptions(Integer participantId) {
    	return participantService.getParticipantById(participantId);
    }
    
    /**
     * Compte le nombre de reponses en fonction de l'item
     * @param participantId
     * @return
     */
    @GetMapping("/item-responses")
    public List<Integer> items(Integer questionId) {   	
    	return reponseService.countEveryResponseOnAnItemOnQuestion(questionId);
    }
    
    
    @GetMapping("/item-responses-of-question")
    public List<Reponse> nbItemByQuestionId(Integer questionId,Integer itemId) {
    	return reponseService.getItemById(questionId,itemId);
    }
}
