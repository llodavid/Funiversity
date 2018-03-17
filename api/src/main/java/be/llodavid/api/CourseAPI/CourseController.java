package be.llodavid.api.CourseAPI;

import be.llodavid.domain.Course;
import be.llodavid.service.CourseService;
import be.llodavid.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;
    private CourseMapper courseMapper;
    private ProfessorService professorService;

    @Inject
    public CourseController(CourseService courseService, CourseMapper courseMapper, ProfessorService professorService) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
        this.professorService = professorService;
    }

    @GetMapping(path = "/{courseID}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CourseDTO getCourse(@PathVariable int courseID) {
        Course course = courseService.getCourse(courseID);
        return courseMapper.createCourseDTO(
                courseService.getCourse(courseID),
                professorService.getProfessor(course.getProfessorID()));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO) {
        courseService.addCourse(courseMapper.createCourse(courseDTO));
        return courseDTO;
    }

    @PutMapping(path = "/{courseID}", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO updateCourse(@PathVariable int courseID, @RequestBody CourseDTO courseDTO) {
        Course updatedCourse = courseService.updateCourse(courseID, courseMapper.createCourse(courseDTO));
        return courseMapper.createCourseDTO(updatedCourse,
                        professorService.getProfessor(updatedCourse.getProfessorID()));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses().stream()
                .map(course -> courseMapper
                        .createCourseDTO(
                                course,
                                professorService.getProfessor(course.getProfessorID())))
                .collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Integer courseID) {
        courseService.removeCourse(courseID);
    }

}
