package com.app.dao;

import java.util.List;

import com.app.pojos.Courses;
import com.app.pojos.CoursesTaught;

public interface ICourse {
  public List<CoursesTaught> getCourses(String faculty_id);
  public List<Courses> getAllCourses();
}
