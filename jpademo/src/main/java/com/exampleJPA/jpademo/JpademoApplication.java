package com.exampleJPA.jpademo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.exampleJPA.jpademo.dao.AppDao;
import com.exampleJPA.jpademo.entity.Course;
import com.exampleJPA.jpademo.entity.Instructor;
import com.exampleJPA.jpademo.entity.InstructorDetail;

@SpringBootApplication
public class JpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			// createInstructor(appDao);
			//createInstructorWithCourses(appDao);
			//findInstructorById(appDao);
			//findCoursesByTypedQuery(appDao);
			
			//findCoursesJoinFetch(appDao);
			
			//updateTheInstructor(appDao);
			//updateCourse(appDao);
			
			deleteTheCourse(appDao);
		};
	}

	private void deleteTheCourse(AppDao appDao) {
		int id=1;
		
		System.out.println("silincek : "+appDao.findCourseById(id));
		
		appDao.deleteCourse(id);
		
		System.out.println("deleted");
		
	}

	private void updateCourse(AppDao appDao) {
		
		int id=13;
		
		Course temp=appDao.findCourseById(id);
		temp.setTitle("FSRU :) ");
		appDao.update(temp);
		
		System.out.println("new title is : "+temp.getTitle());
		
	}

	private void updateTheInstructor(AppDao appDao) {
		int id=2;
		Instructor temp=appDao.findInstructorById(id);
		
		temp.setLastName("beydilli");
		
		appDao.updateInstructor(temp);
		
		System.out.println("new last name is : "+temp.getLastName());
		
		
	}

	private void findCoursesJoinFetch(AppDao appDao) {
		int id=7;
		
		Instructor tempInstructor=appDao.findInstructorByIdJoinFetch(id);
		System.out.println("temp instructor : "+tempInstructor);
		
		System.out.println("and courses : "+tempInstructor.getCourses());
		
		
	}

	private void findCoursesByTypedQuery(AppDao appDao) {
	
		int theId=7;
		Instructor tempInstructor=appDao.findInstructorById(theId);
		
		List<Course> courses=appDao.findCoursesByInstructorId(theId);
		
		tempInstructor.setCourses(courses);
		System.out.println("courses : "+tempInstructor.getCourses());
		
		
	}

	private void findInstructorById(AppDao appDao) {
		int id=2;
		
		Instructor temp=appDao.findInstructorById(id);
		System.out.println("temp instructor : "+temp);
		System.out.println("the course of man : "+temp.getCourses());
		
	}

	private void createInstructorWithCourses(AppDao appDao) {

		Instructor tempInstructor = new Instructor("faruk", "KORKMAZ", "faruk@gmail.com");
		InstructorDetail tempDetail = new InstructorDetail("soldier");
		tempInstructor.setDetail(tempDetail);
		
		
		Course temp1 = new Course("GUN course");
		Course temp2 = new Course("War course");
		Course temp3 = new Course("Fight course");
		tempInstructor.add(temp1);
		tempInstructor.add(temp2);
		tempInstructor.add(temp3);

		appDao.save(tempInstructor);
		System.out.println("done all of them");

	}

	private void createInstructor(AppDao appDao) {
		// TODO Auto-generated method stub
		Instructor tempInstructor = new Instructor("madhu", "patel", "madu@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("detail page is here");
		tempInstructor.setDetail(instructorDetail);

		appDao.save(tempInstructor);
	}

}
