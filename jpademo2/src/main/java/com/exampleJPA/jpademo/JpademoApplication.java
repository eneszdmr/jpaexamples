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

@SpringBootApplication
public class JpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {

			// createCourseAndReviews(appDao);
			// findCourseAndReview(appDao);
			 deleteCourseAndReview(appDao);
		};
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
