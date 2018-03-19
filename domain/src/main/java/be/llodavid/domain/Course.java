package be.llodavid.domain;

import java.util.Objects;

public class Course {
    private int courseID, studypoints, professorID;
    private String name, category;

    public Course(String name, String category, int studypoints,  int professorID) {
        this.studypoints = studypoints;
        this.professorID = professorID;
        this.name = name;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getCourseID() {
        return courseID;
    }

    public int getStudypoints() {
        return studypoints;
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return studypoints == course.studypoints &&
                professorID == course.professorID &&
                Objects.equals(name, course.name) &&
                Objects.equals(category, course.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studypoints, professorID, name, category);
    }
}
