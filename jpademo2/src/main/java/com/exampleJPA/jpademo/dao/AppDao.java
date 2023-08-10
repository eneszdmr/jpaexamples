package com.exampleJPA.jpademo.dao;


import java.util.List;

import com.exampleJPA.jpademo.entity.Course;
import com.exampleJPA.jpademo.entity.Instructor;

public interface AppDao {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int id);
	
	List<Course> findCoursesByInstructorId(int id);
	
	Instructor findInstructorByIdJoinFetch(int id);
	
	void updateInstructor(Instructor instructor);
	
	void update (Course course);
	
	Course findCourseById(int id);
	
	void deleteCourse(int id);
	
	void saveCourse(Course course);
	
	Course getCourseAndReviewsByCourseId(int id);
	
	
	
}
