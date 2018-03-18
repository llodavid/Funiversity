package be.llodavid.domain;

import com.google.common.collect.ImmutableMap;
import javax.inject.Named;
import java.util.*;

@Named
public class ProfessorRepository {
    private Map<Integer,Professor> professors;
    private static int idCounter=0;

    public ProfessorRepository() {
        professors = new HashMap<Integer, Professor>();
        addProfessor(new Professor("John","Doe"));
        addProfessor(new Professor("Jane", "Doe"));
        addProfessor(new Professor("Hubert", "Farnsworth"));
    }
    public Professor getProfessor(int professorID) {
        return professors.get(professorID);
    }
    public void removeProfessor(int professorID) {
        professors.remove(professorID);
    }
    public Professor addProfessor(Professor professor) {
        professor.setProfessorID(idCounter);
        professors.put(idCounter,professor);
        idCounter++;
        return professor;
    }

    public List<Professor> getAllProfessors() {
        return Collections.unmodifiableList(new ArrayList<Professor>(professors.values()));
    }

    public Professor updateProfessor(int professorID, Professor professor) {
        if (professors.containsKey(professorID)) {
            professor.setProfessorID(professorID);
            professors.put(professorID,professor);
        } else {
            throw new IllegalArgumentException("No such professor in the database");
        }
        return professor;
    }
}
