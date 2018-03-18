package be.llodavid.domain;

public class Professor {
    private int professorID=-1;
    private String firstname, lastname;

    public Professor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getProfessorID() {
        return professorID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }
    public boolean hasID() {
        return professorID>0;
    }
}
