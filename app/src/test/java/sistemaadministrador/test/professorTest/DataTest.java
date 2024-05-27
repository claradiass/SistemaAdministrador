package sistemaadministrador.test.professorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.professor.ProfessorService;

public class DataTest {
    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test
    public void TesteDados(){
        ProfessorRepository professorRepository = ProfessorRepository.getInstance();
        ProfessorService professorService = new ProfessorService(professorRepository);
        List<Professor> professors = professorService.searchProfessor("");

        System.out.println(professors);
        assertEquals(5, professors.size());
    }
}
