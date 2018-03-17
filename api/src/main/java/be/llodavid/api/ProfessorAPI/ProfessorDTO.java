package be.llodavid.api.ProfessorAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfessorDTO {

    public int professorID;
    public String firstname, lastname;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }
}
