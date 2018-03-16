package be.llodavid.api.CourseAPI;

public class CourseDTO {
    public int courseID, studypoints, professorID;
    public String name, category;

    public CourseDTO(int courseID, String name, String category, int studypoints, int professorID) {
        this.courseID = courseID;
        this.studypoints = studypoints;
        this.professorID = professorID;
        this.name = name;
        this.category = category;
    }
}
