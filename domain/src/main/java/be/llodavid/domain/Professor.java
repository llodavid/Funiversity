package be.llodavid.domain;

public class Professor {
    private int professorID;
    private String firstname, lastname;
    private static int idCounter=0;

    public Professor(String firstname, String lastname) {
        this.professorID=idCounter++;
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
}
