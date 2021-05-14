package com.app.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.assignments;

@Repository
public interface AssignmentRepository extends JpaRepository<assignments,String>{
   @Query("SELECT a FROM assignments a where a.faculty_id=:faculty_id")
   List<assignments>findAll(String faculty_id);
   @Query("SELECT a FROM assignments a")
   List<assignments>findAllAssi();
//Optional<assignments> findByassignment_id(String id);
}
//new assignments(a.assignment_id,a.course_id,a.doc_name,a.assignment_issued_date,a.assignment_end_date)