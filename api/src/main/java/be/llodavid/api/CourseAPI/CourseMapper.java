package be.llodavid.api.CourseAPI;

import be.llodavid.domain.Course;
import be.llodavid.domain.Professor;

import javax.inject.Named;

@Named
public class CourseMapper {
    public CourseDTO createCourseDTO(Course course, Professor professor) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.courseID = course.getCourseID();
        courseDTO.name = course.getName();
        courseDTO.category = course.getCategory();
        courseDTO.studypoints = course.getStudypoints();
        courseDTO.professorID = course.getProfessorID();
        courseDTO.professorName = professor.getFirstname() + " " + professor.getLastname();
        return courseDTO;
    }

    public Course createCourse(CourseDTO courseDTO) {
        return new Course(courseDTO.name, courseDTO.category, courseDTO.studypoints, courseDTO.professorID);
    }
}
