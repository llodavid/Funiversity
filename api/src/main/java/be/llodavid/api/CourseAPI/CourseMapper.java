package be.llodavid.api.CourseAPI;

import be.llodavid.domain.Course;

import javax.inject.Named;

@Named
public class CourseMapper {
    public CourseDTO createCourseDTO(Course course) {
        return new CourseDTO(course.getCourseID(),
                course.getName(),
                course.getCategory(),
                course.getStudypoints(),
                course.getProfessorID());
    }
}
