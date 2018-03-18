package be.llodavid.api.CourseAPI;

import be.llodavid.domain.Course;
import be.llodavid.domain.Professor;
import be.llodavid.service.ProfessorService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CourseMapper {
    ProfessorService professorService;

    @Inject
    public CourseMapper(ProfessorService professorService) {
        this.professorService = professorService;
    }

    public CourseDTO createCourseDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.courseID = course.getCourseID();
        courseDTO.name = course.getName();
        courseDTO.category = course.getCategory();
        courseDTO.studypoints = course.getStudypoints();
        courseDTO.professorID = course.getProfessorID();
        Professor professor = professorService.getProfessor(course.getProfessorID());
        courseDTO.professorName = professor.getFirstname() + " " + professor.getLastname();
        return courseDTO;
    }

    public Course createCourse(CourseDTO courseDTO) {
        return new Course(courseDTO.name, courseDTO.category, courseDTO.studypoints, courseDTO.professorID);
    }
}
