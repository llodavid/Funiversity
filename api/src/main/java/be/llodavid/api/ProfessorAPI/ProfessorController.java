package be.llodavid.api.ProfessorAPI;

import be.llodavid.domain.Professor;
import be.llodavid.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    private ProfessorService professorService;
    private ProfessorMapper professorMapper;

    @Inject
    public ProfessorController(ProfessorService professorService, ProfessorMapper professorMapper) {
        this.professorService = professorService;
        this.professorMapper = professorMapper;
    }

    @GetMapping(path = "/{professorID}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDTO getProfessor(@PathVariable int professorID) {
        return professorMapper.createProfessorDTO(professorService.getProfessor(professorID));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDTO createProfessor(@RequestBody ProfessorDTO professorDTO) {
        Professor createdProfessor = professorService.addProfessor(professorMapper.createProfessor(professorDTO));
        return professorMapper.createProfessorDTO(createdProfessor);
    }

    @PutMapping(path = "/{professorID}", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDTO updateProfessor(@PathVariable int professorID, @RequestBody ProfessorDTO professorDTO) {
        Professor updatedProfessor = professorService.updateProfessor(professorID, professorMapper.createProfessor(professorDTO));
        return professorMapper.createProfessorDTO(updatedProfessor);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDTO> getAllProfessors() {
        return professorService.getAllProfessors().stream()
                .map(professor -> professorMapper.createProfessorDTO(professor))
                .collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{professorID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfessor(@PathVariable Integer professorID) {
        professorService.removeProfessor(professorID);
    }
}
