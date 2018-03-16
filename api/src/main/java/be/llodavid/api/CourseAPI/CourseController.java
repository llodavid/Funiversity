package be.llodavid.api.CourseAPI;

import be.llodavid.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/courses")
public class CourseController {
    CourseService courseService;
    CourseMapper courseMapper;

    @Inject
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @GetMapping(path="/{courseID}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CourseDTO getCourse(@PathVariable int courseID) {
        return courseMapper.createCourseDTO(courseService.getCourse(courseID));
    }
}
