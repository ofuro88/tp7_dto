package com.mydigitalschool.dao_orm.sondage.controllers;

import java.util.List;

import com.mydigitalschool.dao_orm.sondage.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mydigitalschool.dao_orm.sondage.dtos.Participant;
import com.mydigitalschool.dao_orm.sondage.dtos.Question;
import com.mydigitalschool.dao_orm.sondage.dtos.Reponse;

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
    ItemDuoService itemDuoService;
    
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
     * @param questionId
     * @return
     */
//    @GetMapping("/item-responses")
//    public List<Integer> items(Integer questionId,Integer itemId) {   	
//    	return reponseService.countEveryResponseOnAnItemOnQuestion(questionId);
//    }
    
    /**
     * 
     * @return Nombre de reponses sur tel item
     */
    @GetMapping("item-responses")
    public List<Integer> numberOfResponseOnItem(){
    	return reponseService.getNumberOfResponseOfItem();
    }
    
    /**
     * nombre de participants ayant répondu à deux items donnés (ItemDuo)
     * @param itemId1
     * @param itemId2
     */
    @GetMapping("/responses-of-two-items")
    public String itemDuo(Integer itemId1, Integer itemId2) {
        if(itemId1 == null || itemId2 == null){
            return "demande incorrect";
        }
        else{
            return itemDuoService.getItemDuo(itemId1, itemId2);
        }
    }

    /**
     * activité principale des développeurs de tel langage
     * recupère les participants ayant répondu ? à une question et renvoi la réponse la plus donné à la question ?
     * @param questionId1
     * @param itemId
     * @param questionId2
     */
    @GetMapping("/response-of-question-by-response-of-other-question")
    public String itemD(Integer questionId1, Integer itemId, Integer questionId2) {
        if(questionId1 == null || itemId == null || questionId2 == null){
            return "demande incorrect";
        }
        else{
            return itemDuoService.getItemOfQuestionByOtherQuestion(questionId1, itemId, questionId2);
        }
    }


    
    /**
     * Retourne le nombre de reponse sur chaque item d'une question donnée
     * @param questionId
     * @return
     */
    @GetMapping("/item-responses-of-question")
    public List<Integer> numberOfItemsByQuestion(Integer questionId) {
    	return reponseService.countEveryResponseOnAnItemOnQuestion(questionId);
    }
}
