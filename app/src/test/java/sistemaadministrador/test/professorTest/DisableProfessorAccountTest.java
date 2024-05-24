package sistemaadministrador.test.professorTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableProfessorAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.ProfessorService;

public class DisableProfessorAccountTest {
    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test
    public void criacaoDeConta(){
        String name = "Jaindson";
        int indice = 0;
        String input = name + "\n" + indice;

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        DisableProfessorAccount disableProfessorAccount = new DisableProfessorAccount();
        disableProfessorAccount.execute();

        System.setOut(originalOut);

        ProfessorRepository professorRepository = ProfessorRepository.getInstance();
        ProfessorService professorService = new ProfessorService(professorRepository);
        List<Professor> professors = professorService.searchProfessor("");

        assertFalse(professors.get(0).verifyStatus());
    }
}
