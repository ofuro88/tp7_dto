package com.mydigitalschool.dao_orm.sondage;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.mydigitalschool.dao_orm.sondage.controllers.QueryController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

//		// creation du controleur
//		QueryController queryController = new QueryController();
//
//		// lancement des requetes affichées en log
//			// nombre de participants
//		System.out.print("combien y a-t-il des participants au sondage ?");
//		System.out.println(queryController.numberOfParticipants());
//			// nombre questions ?
//		System.out.print("combien y a-t-il des questions dans le sondage ?");
//		System.out.println(queryController.numberOfQuestions());
	}
}
