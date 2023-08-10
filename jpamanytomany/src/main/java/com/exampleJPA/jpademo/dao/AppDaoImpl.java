package com.exampleJPA.jpademo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleJPA.jpademo.entity.Course;
import com.exampleJPA.jpademo.entity.Instructor;
import com.exampleJPA.jpademo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Service
public class AppDaoImpl implements AppDao{
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Autowired
	public AppDaoImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	@Transactional
	public void save(Course theCourse) {
		entityManager.persist(theCourse);
		
	}

	@Override
	public Instructor findInstructorById(int id) {
	
		
		return entityManager.find(Instructor.class, id);
	}

	@Override
	public List<Course> findCoursesByInstructorId(int id) {


		TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id= :data",Course.class);
		query.setParameter("data", id);
		
		List<Course> courses=query.getResultList();
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int id) {
		// TODO Auto-generated method stub
		TypedQuery<Instructor> query=entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.detail where i.id=:data",Instructor.class);
		
		query.setParameter("data", id);
		
		Instructor instructor=query.getSingleResult();
		return instructor;
	}

	@Override
	@Transactional
	public void updateInstructor(Instructor instructor) {

		entityManager.merge(instructor);
		
		
	}

	@Override
	@Transactional
	public void update(Course course) {
		// TODO Auto-generated method stub
		entityManager.merge(course);
	}

	@Override
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Course.class, id);
	}

	@Override
	@Transactional
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		Course tempc=entityManager.find(Course.class, id);
		
		entityManager.remove(tempc);
		
	}
	

	@Override
	@Transactional
	public void saveCourse(Course course) {
		entityManager.persist(course);
		
		
	}

	@Override
	public Course getCourseAndReviewsByCourseId(int id) {
		TypedQuery<Course> query=entityManager.createQuery("select c from Course c JOIN FETCH c.reviews where c.id=:data",Course.class);
		
		query.setParameter("data", id);
		Course course=query.getSingleResult();
		
		
		
		return course;
		
	}

	@Override
	@Transactional
	public void save(Instructor thInstructor) {
		entityManager.persist(thInstructor);
		
	}

	@Override
	public Course findCourseAndStudentsByCourseId(int id) {
		
		TypedQuery<Course> qry =entityManager.createQuery("select c FROM Course c JOIN FETCH c.students where c.id=:theId",Course.class);
		qry.setParameter("theId", id);
		
		Course crs=qry.getSingleResult();
		
		return crs;
	}

	@Override
	public Student findCourseAndStudentsByStudentId(int id) {

		TypedQuery<Student> query =entityManager.createQuery("select s FROM Student s JOIN FETCH s.courses where s.id=:id",Student.class);
		
		query.setParameter("id", id);
		
		Student student=query.getSingleResult();
		return student;
	}

	@Override
	@Transactional
	public void addSomeCourseToStudent(Student student) {
		
		entityManager.merge(student);
		
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		
		Student temp=entityManager.find(Student.class, id);
		
		entityManager.remove(temp);
		
	}

}
