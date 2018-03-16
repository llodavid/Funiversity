package be.llodavid.api.ProfessorAPI;

import be.llodavid.domain.Professor;
import be.llodavid.service.ProfessorService;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collector;
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

        professorService.addProfessor(professorMapper.createProfessor(professorDTO));
        return professorDTO;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDTO> getAllProfessors() {
        return professorService.getAllProfessors().stream()
                .map(professor -> professorMapper.createProfessorDTO(professor))
                .collect(Collectors.toList());
    }
}
