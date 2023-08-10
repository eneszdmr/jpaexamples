package com.exampleJPA.jpademo.dao;


import java.util.List;

import com.exampleJPA.jpademo.entity.Course;
import com.exampleJPA.jpademo.entity.Instructor;
import com.exampleJPA.jpademo.entity.Student;

public interface AppDao {
	
	void save(Course theCourse);
	void save(Instructor thInstructor);
	
	Instructor findInstructorById(int id);
	
	List<Course> findCoursesByInstructorId(int id);
	
	Instructor findInstructorByIdJoinFetch(int id);
	
	void updateInstructor(Instructor instructor);
	
	void update (Course course);
	
	Course findCourseById(int id);
	
	void deleteCourse(int id);
	
	void saveCourse(Course course);
	
	Course getCourseAndReviewsByCourseId(int id);
	
	Course findCourseAndStudentsByCourseId(int id);
	
	Student findCourseAndStudentsByStudentId(int id);
	
	void addSomeCourseToStudent(Student student);
	
	void deleteStudent(int id);
	
}
