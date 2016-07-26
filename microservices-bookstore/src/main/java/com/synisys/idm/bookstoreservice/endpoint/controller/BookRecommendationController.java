package com.synisys.idm.bookstoreservice.endpoint.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ashot.karapetyan on 7/24/16.
 */

@RestController
@RequestMapping("/")
public class BookRecommendationController {

	@RequestMapping(value = "recommended")
	public String readingList(){
		return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
	}

}
