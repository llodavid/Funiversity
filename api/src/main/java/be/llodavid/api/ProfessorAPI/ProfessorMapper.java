package be.llodavid.api.ProfessorAPI;

import be.llodavid.domain.Professor;

import javax.inject.Named;

@Named
public class ProfessorMapper {

    public ProfessorDTO createProfessorDTO(Professor professor) {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setProfessorID(professor.getProfessorID());
        professorDTO.setFirstname(professor.getFirstname());
        professorDTO.setLastname(professor.getLastname());
        return professorDTO;
    }

    public Professor createProfessor(ProfessorDTO professorDTO) {
        return new Professor(professorDTO.firstname, professorDTO.lastname);
    }
}
