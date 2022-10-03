package com.masai.service;

import java.util.List;

import com.masai.exceptions.TutorialNotFoundException;
import com.masai.model.Tutorial;

public interface TutorialService {
	public Tutorial saveTutorial(Tutorial tutorial);
	public List<Tutorial> getAllTutorial();
	public Tutorial getTutorialById(int id)throws TutorialNotFoundException;
	public String updateTutorialById(Tutorial tutorial)throws TutorialNotFoundException;
	public String deleteTutorialById(int id)throws TutorialNotFoundException;
	public String deleteAllTutorials();
	public List<Tutorial> getTutorialsByPublished(boolean published);
	public List<Tutorial> getTutorialsByTitle(String keyword);
	
}
