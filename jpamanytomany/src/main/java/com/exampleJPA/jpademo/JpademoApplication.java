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
import com.exampleJPA.jpademo.entity.Review;
import com.exampleJPA.jpademo.entity.Student;

@SpringBootApplication
public class JpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {

			//addCourseAndStudent(appDao);

			// findStudentAndCourse(appDao);

			 //findCourseAndStudents(appDao);

			//	addCourseToStudent(appDao);
			
			//deleteCourseById(appDao);
			
			//	deleteStudent(appDao);
			
		};
	}

	private void deleteStudent(AppDao appDao) {
		
		int id =15;
		Student temp=appDao.findCourseAndStudentsByStudentId(id);
		System.out.println("heyy this man will be deleted right dont make wrong "+temp.getFirstName());
		appDao.deleteStudent(id);
		
	}

	private void deleteCourseById(AppDao appDao) {
		
		int id =1;
		Course course=appDao.findCourseById(id);
		System.out.println("this course will be deleted : "+course.getTitle());
		
		appDao.deleteCourse(id);
		System.out.println("OKAY we have deleted the course see you later..");
		
	}

	private void addCourseToStudent(AppDao appDao) {
		
			int id = 15;
			
			Student aStudent=appDao.findCourseAndStudentsByStudentId(id);
			System.out.println(aStudent);
			
			Course newCourse=new Course("Software and Java Lessons");
			Course oldCourse1=appDao.findCourseById(2);
			//Course oldCourse2=appDao.findCourseById(2);
			//enes.addCourse(newCourse);
			aStudent.addCourse(oldCourse1);
			//enes.addCourse(oldCourse2);
			
			appDao.addSomeCourseToStudent(aStudent);
			System.out.println(appDao.findCourseAndStudentsByStudentId(id));
		
	}

	private void findCourseAndStudents(AppDao appDao) {

		int id = 13;
		Student student = appDao.findCourseAndStudentsByStudentId(id);
		System.out.println("students : " + student);

		System.out.println("and courses : " + student.getCourses());
	}

	private void findStudentAndCourse(AppDao appDao) {
		int id = 2;

		Course temp = appDao.findCourseAndStudentsByCourseId(id);

		System.out.println("all courses: " + temp);
		System.out.println("all students : " + temp.getStudents());

	}

	private void addCourseAndStudent(AppDao appDao) {

		Course tempCourse1 = new Course("Pokemon movie lesson");

		Student newStudent1 = new Student("firkan", "demir", "firkan@gmail.com");

		tempCourse1.addStudent(newStudent1);

		System.out.println("new added : " + tempCourse1);
		System.out.println("new students : " + tempCourse1.getStudents());

		appDao.save(tempCourse1);

	}

	private void deleteCourseAndReview(AppDao appDao) {

		int id = 6;
		System.out.println("this id course will remove " + id);
		appDao.deleteCourse(id);

	}

	private void findCourseAndReview(AppDao appDao) {
		// TODO Auto-generated method stub
		int id = 6;
		// appDao.getCourseAndReviewsByCourseId(id);
		Course temp = appDao.getCourseAndReviewsByCourseId(id);

		System.out.println("courses : " + temp);

		System.out.println("now here it is : " + temp.getReviews());
	}

	private void createCourseAndReviews(AppDao appDao) {

		Course tempC = new Course("Paint ");
		Review review = new Review("salvador dali ");
		Review review2 = new Review("picasso ");
		Review review3 = new Review("Da Vinci ");
		tempC.addReview(review);
		tempC.addReview(review2);
		tempC.addReview(review3);

		appDao.saveCourse(tempC);

	}

}
