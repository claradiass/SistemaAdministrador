package sistemaadministrador.test.professorTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableProfessorAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.professor.ProfessorService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisableProfessorAccountSuccessTest {
    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test
    public void testDisableProfessorAccount_Successful() {
        String name = "Jaidson";
        int index = 0;
        String input = name + "\n" + index;

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

    @Test
    public void testDisableProfessorAccount_Exception() {
        String name = "Jaindson";
        int index = 0;
        String input = name + "\n" + index;
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        DisableProfessorAccount command = new DisableProfessorAccount();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });

        System.setOut(originalOut);

        ProfessorRepository professorRepository = ProfessorRepository.getInstance();
        ProfessorService professorService = new ProfessorService(professorRepository);
        List<Professor> professors = professorService.searchProfessor("");

        assertFalse(professors.get(0).verifyStatus());
        assertEquals("User already deactivated", exception.getMessage());
    }
}
