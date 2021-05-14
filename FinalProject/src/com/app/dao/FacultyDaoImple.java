package com.app.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.exception.CustomException;

import com.app.pojos.CoursesTaught;
import com.app.pojos.DataStudent;

import com.app.pojos.Trainer;
import com.app.pojos.assignments;

@Repository
@Transactional
public class FacultyDaoImple implements IFacultyDao {
	@PersistenceContext
	private EntityManager mgr;

	@Override
	public Trainer AuthenticateUser(String email, String pass) throws CustomException {

		System.out.println("frst line of authenticate user");

		String jpql = "select f from faculty_details f where f.faculty_email=:email and f.faculty_password=:pass";
		Trainer t = mgr.createQuery(jpql, Trainer.class).setParameter("email", email).setParameter("pass", pass)
				.getSingleResult();
		System.out.println(t);
		System.out.println("jpql success");
		if (t != null) {
			return t;

		}
		throw new CustomException("could not find any faculty of give information");
	}

	@Override
	public ArrayList<CoursesTaught> findAllCoursesTaughtByFaculty(String faculty_id) {
		ArrayList<CoursesTaught> courselist = new ArrayList<>();
		courselist = (ArrayList<CoursesTaught>) mgr
				.createQuery("select c from CoursesTaught c where c.faculty_id=:id", CoursesTaught.class)
				.setParameter("id", faculty_id).getResultList();

		return courselist;
	}

	@Override
	public ArrayList<assignments> findAllAssignmentsGivenByFaculty(String faculty_id) {
		String findcoursesassignments = "select a from AssignmentDetails a where a.faculty_id=:id";
		ArrayList<assignments> lst = new ArrayList<>();

		lst = (ArrayList<assignments>) mgr.createQuery(findcoursesassignments, assignments.class)
				.setParameter("id", faculty_id).getResultList();
		return lst;
	}

	@Override
	public void uploadAssignments(assignments obj) {
		mgr.merge(obj);
		System.out.println("Saved " + obj + " successfully in database");

	}

	@Override
	public ArrayList<String> findAssignmentsOfCourseMentioned(String course_id) {
		String jpql = "select s.assign_id from AssignmentDetails s where s.course_id=:c_id";
		return (ArrayList<String>) mgr.createQuery(jpql, String.class).setParameter("c_id", course_id).getResultList();

	}

	

	@Override
	public ArrayList<DataStudent> selectAllTheSubmittedAssignmentsByGivenAssignmentId(String assignment_id) {

		String jpql = "select s from StudentAssignmentDetails s where s.assignmentId=:id and s.gradeObtained='0'";
		return (ArrayList<DataStudent>) mgr.createQuery(jpql, DataStudent.class).setParameter("id", assignment_id)
				.getResultList();
	}

	@Override
	public void updateEvaluatedStudentAssignment(DataStudent evaluatedAssignments) {
		// TODO Auto-generated method stub

	}

	@Override
	public assignments findById(String a_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFaculty(Trainer f) {
		// TODO Auto-generated method stub

	}
}
