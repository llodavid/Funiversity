package be.llodavid.domain;

import com.google.common.collect.ImmutableMap;
import javax.inject.Named;
import java.util.*;

@Named
public class ProfessorRepository {
    private Map<Integer,Professor> professors;

    public ProfessorRepository() {
        professors = new ImmutableMap.Builder<Integer, Professor>()
                .put(0,new Professor("John","Doe"))
                .put(1, new Professor("Jane", "Doe"))
                .put(2, new Professor("Hubert", "Farnsworth"))
                .build();
    }
    public Professor getProfessor(int professorID) {
        return professors.get(professorID);
    }
    public void removeProfessor(int professorID) {
        professors.remove(professorID);
    }
    public void addProfessor(Professor professor) {
        professors.put(professor.getProfessorID(),professor);
    }

    public List<Professor> getAllProfessors() {
        return Collections.unmodifiableList(new ArrayList<Professor>(professors.values()));
    }
}
