package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Tutorial;
@Repository
public interface TutorialDao extends JpaRepository<Tutorial, Integer>{

}
