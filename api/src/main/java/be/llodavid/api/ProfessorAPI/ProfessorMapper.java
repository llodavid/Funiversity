package be.llodavid.api.ProfessorAPI;

import be.llodavid.domain.Professor;

import javax.inject.Named;

@Named
public class ProfessorMapper {

    public ProfessorDTO createProfessorDTO(Professor professor) {
        return new ProfessorDTO(professor.getProfessorID(),
                professor.getFirstname(),
                professor.getLastname());
    }
    public Professor createProfessor (ProfessorDTO professorDTO) {
        return new Professor(professorDTO.firstname,professorDTO.lastname);
    }
}
