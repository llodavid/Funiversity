package be.llodavid.service;

import be.llodavid.domain.Professor;
import be.llodavid.domain.ProfessorRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ProfessorService {
    ProfessorRepository professorRepository;

    @Inject
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor getProfessor(int professorID) {
        return professorRepository.getProfessor(professorID);
    }

    public void removeProfessor(int professorID) {
        professorRepository.removeProfessor(professorID);
    }

    public void addProfessor(Professor professor) {
        professorRepository.addProfessor(professor);
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.getAllProfessors();
    }
}
