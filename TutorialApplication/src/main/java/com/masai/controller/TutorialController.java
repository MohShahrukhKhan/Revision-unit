package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Tutorial;
import com.masai.service.TutorialService;

@RestController
@RequestMapping("/api")
public class TutorialController {
	@Autowired
	private TutorialService tutorialService;
	
	@PostMapping("/tutorials")
	public ResponseEntity<Tutorial> saveTutorialHandler(@RequestBody Tutorial tutorial){
		
		return new ResponseEntity<Tutorial>(tutorialService.saveTutorial(tutorial), HttpStatus.CREATED);
	}
	
	@GetMapping("/tutorials")
	public List<Tutorial> getTutorialsHandler(){
		return tutorialService.getAllTutorial();
	}
	
	@GetMapping("/tutorials/{id}")
	public Tutorial getTutorialsByIdHandler(@PathVariable("id") Integer id){
		
		return tutorialService.getTutorialById(id);
	}
	
	@PutMapping("/tutorials/{id}")
    public String updateTutorialsByIdHandler(@PathVariable("id") Integer id,@RequestBody Tutorial tutorial){
		
		tutorial.setId(id);
		return tutorialService.updateTutorialById(tutorial);
	}
	
	
	@DeleteMapping("/tutorials/{id}")
	public String deleteTutorialByIdhandler(@PathVariable("id") Integer id) {
		return tutorialService.deleteTutorialById(id);
	}
	
	@DeleteMapping("/tutorials")
	public String deleteAllTutorialHandler() {
		return tutorialService.deleteAllTutorials();
	}
	
	@GetMapping("/tutorials/published")
	public List<Tutorial> getAllTutorialByPublishedHandler(){
		return tutorialService.getTutorialsByPublished(true);
	}
	
	@GetMapping("/tutorials")
	public List<Tutorial> getAllTutorialByTitle(@RequestParam(name="title") String title){
		
		return tutorialService.getTutorialsByTitle(title);
	}
	
	

}
