package be.llodavid.service;

import be.llodavid.domain.Course;
import be.llodavid.domain.CourseRepository;
import be.llodavid.domain.Professor;
import be.llodavid.service.Exceptions.ResourceNotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CourseService {
    private static CourseRepository courseRepository;

    @Inject
    public CourseService(CourseRepository courseRepository) {
        CourseService.courseRepository = courseRepository;
    }

    public Course getCourse(int courseID) {
        verifyIfCourseExists(courseID);
        return courseRepository.getCourse(courseID);
    }
    public void deleteCourse(int courseID) {
        verifyIfCourseExists(courseID);
        courseRepository.deleteCourse(courseID);
    }
    public void addCourse(Course course) {
        courseRepository.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Course updateCourse(int courseID, Course course) {
        ProfessorService.verifyIfProfessorExists(course.getProfessorID());
        verifyIfCourseExists(courseID);
        return courseRepository.updateCourse(courseID,course);
    }

    public void removeCourse(int courseID) {
        verifyIfCourseExists(courseID);
        courseRepository.deleteCourse(courseID);
    }

    static void verifyIfCourseExists(int courseID) {
        if (courseRepository.getCourse(courseID)==null) {
            throw new ResourceNotFoundException(Course.class.getSimpleName(),String.format("ID: %s", courseID));
        }
    }
}
