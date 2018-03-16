package be.llodavid.domain;

import com.google.common.collect.ImmutableMap;
import javax.inject.Named;
import java.util.Map;

@Named
public class CourseRepository {
    private Map<Integer, Course> courses;
    public CourseRepository() {
        courses = new ImmutableMap.Builder<Integer, Course>()
                .put(0,new Course("Math 101","Mathematics",4,1))
                .put(1,new Course("Advanced Algebra","Mathematics",4,0))
                .put(2,new Course("How to use a PC, for Dummies","Computer Sciences",5,1))
                .build();
    }
    public Course getCourse(int courseID) {
        return courses.get(courseID);
    }
    public void deleteCourse(int courseID) {
        courses.remove(courseID);
    }
    public void addCourse(Course course) {
        courses.put(course.getCourseID(), course);
    }
}
