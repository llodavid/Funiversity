package be.llodavid.domain;

public class Course {
    private int courseID, studypoints, professorID, idCounter=0;
    private String name, category;

    public Course(String name, String category, int studypoints,  int professorID) {
        this.studypoints = studypoints;
        this.professorID = professorID;
        this.name = name;
        this.category = category;
        this.courseID = idCounter++;
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
}
