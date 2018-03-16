package be.llodavid.service;

import be.llodavid.domain.Course;
import be.llodavid.domain.CourseRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CourseService {
    CourseRepository courseRepository;

    @Inject
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course getCourse(int courseID) {
        return courseRepository.getCourse(courseID);
    }
    public void deleteCourse(int courseID) {
        courseRepository.deleteCourse(courseID);
    }
    public void addCourse(Course course) {
        courseRepository.addCourse(course);
    }
}