package be.llodavid.api.ProfessorAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfessorDTO {

    public int professorID;
    public String firstname, lastname;

    public ProfessorDTO(int professorID, String firstname, String lastname) {
        this.professorID = professorID;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
