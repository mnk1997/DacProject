package com.app.dao;

import java.util.ArrayList;

import com.app.exception.CustomException;

import com.app.pojos.CoursesTaught;
import com.app.pojos.DataStudent;

import com.app.pojos.Trainer;
import com.app.pojos.assignments;

public interface IFacultyDao {
	public Trainer AuthenticateUser(String email, String pass) throws CustomException;

	public ArrayList<assignments> findAllAssignmentsGivenByFaculty(String faculty_id);

	public ArrayList<CoursesTaught> findAllCoursesTaughtByFaculty(String faculty_id);

	public void uploadAssignments(assignments obj);

//public List<FacultyAssignment> findAllAssignmentByFaculty();
	public ArrayList<String> findAssignmentsOfCourseMentioned(String course_id);

	public void updateEvaluatedStudentAssignment(DataStudent evaluatedAssignments);

	public ArrayList<DataStudent> selectAllTheSubmittedAssignmentsByGivenAssignmentId(String assignment_id);

	public assignments findById(String a_id);

	public void addFaculty(Trainer f);
}
