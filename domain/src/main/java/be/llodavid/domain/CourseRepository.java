package be.llodavid.domain;

import javax.inject.Named;
import java.util.*;

@Named
public class CourseRepository {
    private Map<Integer, Course> courses;
    private static int idCounter = 0;

    public CourseRepository() {
        courses = new HashMap<Integer, Course>();
        addCourse(new Course("Math 101", "Mathematics", 4, 1));
        addCourse(new Course("Advanced Algebra", "Mathematics", 4, 0));
        addCourse(new Course("How to use a PC, for Dummies", "Computer Sciences", 5, 1));
    }

    public Course getCourse(int courseID) {
        return courses.get(courseID);
    }

    public void deleteCourse(int courseID) {
        courses.remove(courseID);
    }

    public void addCourse(Course course) {
        course.setCourseID(idCounter);
        courses.put(idCounter, course);
        idCounter++;
    }

    public List<Course> getAllCourses() {
        return Collections.unmodifiableList(new ArrayList<Course>(courses.values()));

    }

    public Course updateCourse(int courseID, Course course) {
        if(courses.containsKey(courseID)) {
            courses.put(courseID,course);
        }
        else {
            throw new IllegalArgumentException("Course not found in the database!");
        }
        return course;
    }
}
