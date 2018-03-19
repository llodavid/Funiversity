package be.llodavid.service;

import be.llodavid.domain.Professor;
import be.llodavid.domain.ProfessorRepository;
import be.llodavid.service.Exceptions.ResourceNotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ProfessorService {
    private static ProfessorRepository professorRepository;

    @Inject
    public ProfessorService(ProfessorRepository professorRepository) {
        ProfessorService.professorRepository = professorRepository;
    }

    public Professor getProfessor(int professorID) {
        verifyIfProfessorExists(professorID);
        return professorRepository.getProfessor(professorID);
    }

    public void removeProfessor(int professorID) {
        verifyIfProfessorExists(professorID);
        professorRepository.removeProfessor(professorID);
    }

    public Professor addProfessor(Professor professor) {
        return professorRepository.addProfessor(professor);
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.getAllProfessors();
    }

    public Professor updateProfessor(int professorID, Professor professor) {
        verifyIfProfessorExists(professorID);
        return professorRepository.updateProfessor(professorID, professor);
    }

    static void verifyIfProfessorExists(int professorID) {
        if (professorRepository.getProfessor(professorID) == null) {
            throw new ResourceNotFoundException(Professor.class.getSimpleName(), String.format("ID: %s", professorID));
        }

    }
}
