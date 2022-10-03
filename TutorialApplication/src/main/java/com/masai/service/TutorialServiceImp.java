package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.TutorialDao;

import com.masai.exceptions.TutorialNotFoundException;
import com.masai.model.Tutorial;
@Service
public class TutorialServiceImp implements TutorialService{
	@Autowired
	private TutorialDao tutorialDao;

	@Override
	public Tutorial saveTutorial(Tutorial tutorial) {
		// TODO Auto-generated method stub
		tutorialDao.save(tutorial);
		
		return tutorial;
	}

	@Override
	public List<Tutorial> getAllTutorial() {
		// TODO Auto-generated method stub
		return tutorialDao.findAll();
	}

	@Override
	public Tutorial getTutorialById(int id) {
		// TODO Auto-generated method stub
		return tutorialDao.findById(id).orElseThrow(()-> new TutorialNotFoundException("Tutorial does Not exist with ID "+id));
	}

	@Override
	public String updateTutorialById(Tutorial tutorial) {
		// TODO Auto-generated method stub
		tutorialDao.findById(tutorial.getId()).orElseThrow(()-> new TutorialNotFoundException("Tutorial does Not exist with ID "));
	    tutorialDao.save(tutorial);
	    
		return "update Succesfully!";
	}

	@Override
	public String deleteTutorialById(int id) {
		// TODO Auto-generated method stub
		 tutorialDao.findById(id).orElseThrow(()-> new TutorialNotFoundException("Tutorial does Not exist with ID "+id));
		 tutorialDao.deleteById(id);
		 return "Delete Succesfully!";
	}

	@Override
	public String deleteAllTutorials() {
		// TODO Auto-generated method stub
		tutorialDao.deleteAll();
		 return "Delete All Succesfully!";
	}

	@Override
	public List<Tutorial> getTutorialsByPublished(boolean published) {
		// TODO Auto-generated method stub
		List<Tutorial> ans=new ArrayList<>();
		List<Tutorial> list=tutorialDao.findAll();
		for(Tutorial t: list) {
			if(t.isPublished_Stutus()==published)ans.add(t);
		}
		return ans;
	}

	@Override
	public List<Tutorial> getTutorialsByTitle(String keyword) {
		// TODO Auto-generated method stub
		List<Tutorial> ans=new ArrayList<>();
		List<Tutorial> list=tutorialDao.findAll();
		for(Tutorial t: list) {
			if(t.getTitle().contains(keyword))ans.add(t);
		}
		return ans;
		
	}

}
